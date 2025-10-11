import sys
input=sys.stdin.readline
n,m=map(int,input().split())
edges=[list(map(int,input().split())) for _ in range(m)]

parent=[i for i in range(n+1)]
def find(a):
    root=a
    while root!=parent[root]:
        root=parent[root]
    while root!=a:
        p=parent[a]
        parent[a]=root
        a=p
    return root

def union(a,b):
    ra,rb=find(a),find(b)
    if ra<rb:
        parent[rb]=ra
    elif rb<ra:
        parent[ra]=rb

def kruskal(edges):
    edges.sort(key=lambda x: x[2])
    total=0
    max_edge=0
    for a,b,cost in edges:
        if find(a)!=find(b):
            union(a,b)
            total+=cost
            max_edge=cost
    return total-max_edge
print(kruskal(edges))
