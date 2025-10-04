import sys
input=sys.stdin.readline
n=int(input())
m=int(input())
roads=[list(map(int,input().split())) for _ in range(n)]
plan=list(map(int,input().split()))
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

def union(a,b):
    pa,pb=find(a),find(b)
    if pa==pb:
        return 
    elif pa<pb:
        parent[pb]=pa
    elif pb<pa:
        parent[pa]=pb

for i in range(n):
    for j in range(n):
        if roads[i][j]==1:
            union(i+1,j+1)

root=find(plan[0])
possible=True
for city in plan[1:]:
    if find(city)!=root:
        possible=False
        break
print("YES" if possible else "NO")
