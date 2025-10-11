import sys
input=sys.stdin.readline
v,e=map(int,input().split())
edges=[list(map(int,input().split())) for _ in range(e)]
parent=[i for i in range(v+1)]

def find(x):
    root=x
    while root!=parent[root]:
        root=parent[root]
    while root!=x:
        p=parent[x]
        parent[x]=root
        x=p
    return root

def union(a,b):
    ra,rb=find(a),find(b)
    if ra<rb:
        parent[rb]=ra
    elif rb<ra:
        parent[ra]=rb

def kruskal(edges):
    edges.sort(key=lambda x:x[2])
    total=0
    for a,b,cost in edges:
        if find(a)!=find(b):
            union(a,b)
            total+=cost
    return total

print(kruskal(edges))
