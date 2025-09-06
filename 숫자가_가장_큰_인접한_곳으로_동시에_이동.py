n,m,t=map(int,input().split())
a=[list(map(int, input().split())) for _ in range(n)]
marbles=[tuple(map(int,input().split())) for _ in range(m)]
marbles=[(x-1,y-1) for x,y in marbles]
r=[p[0] for p in marbles]
c=[p[1] for p in marbles]

dxy=[(-1,0),(1,0),(0,-1),(0,1)]
def in_range(x,y):
    return 0<=x<n and 0<=y<n

def move(x,y):
    best_val=-10**18
    best=None
    for dx,dy in dxy:
        nx,ny=x+dx,y+dy
        if in_range(nx,ny):
            if best_val<a[nx][ny]:
                best_val=a[nx][ny]
                best=(nx,ny)
    return best if best is not None else (x,y)

from collections import Counter

def rm_duplicate(rr,cc):
    position=list(zip(rr,cc))
    cnt=Counter(position)
    kept=[pos for pos in position if cnt[pos]==1]
    if not kept:
        return [],[]
    nr=[pos[0] for pos in kept]
    nc=[pos[1] for pos in kept]
    return nr,nc

for _ in range(t):
    nr, nc=[],[]
    for x,y in zip(r,c):
        nx,ny=move(x,y)
        nr.append(nx)
        nc.append(ny)
    r,c=rm_duplicate(nr,nc)
print(len(r))
