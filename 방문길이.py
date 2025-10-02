from collections import defaultdict
def solution(dirs):
    def in_range(x,y):
        return -5<=x<=5 and -5<=y<=5
    dirs=list(dirs)
    x=0;y=0
    visited=defaultdict(set)
    for dir in dirs:
        if dir=="L":
            nx,ny=x-1,y
        elif dir=="R":
            nx,ny=x+1,y
        elif dir=="U":
            nx,ny=x,y+1
        elif dir=="D":
            nx,ny=x,y-1
        if in_range(nx,ny):
            visited[(x,y)].add((nx,ny))
            visited[(nx,ny)].add((x,y))
            x,y=nx,ny
    print(visited)
    total=sum(len(v) for v in visited.values())
    return total//2
