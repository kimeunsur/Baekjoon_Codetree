import sys
input=sys.stdin.readline
n,m=map(int,input().split())
calc=[list(map(int,input().split())) for _ in range(m)]
parent=[i for i in range(n+1)]
def find(n):
    root=n 
    while parent[root]!=root:
        root=parent[root]
    while root!=n:
        p=parent[n]
        parent[n]=root
        n=p
    return root

for c in calc:
    a,b=c[1],c[2]
    pa,pb=find(a),find(b)
    if c[0]==0:
        if pa<pb:
            parent[pb]=pa
        elif pb<pa:
            parent[pa]=pb
    else:
        print("YES" if pa==pb else "NO")
