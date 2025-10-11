import sys
from collections import defaultdict
input=sys.stdin.readline
t=int(input().strip())
ans=[]
for _ in range(t):
    f=int(input().strip())
    order=1
    names=defaultdict(int)
    parents=[i for i in range(f*2+1)]
    infos=[map(str,input().split()) for _ in range(f)]
    size=[1 for _ in range(f*2+1)]
    def find(a):
        root=a
        while root!=parents[root]:
            root=parents[root]
        while root!=a:
            p=parents[a]
            parents[a]=root
            a=p
        return root
    def union(a,b):
        pa,pb=find(a),find(b)
        if pa==pb:
            return size[pa]
        if size[pa]<size[pb]:
            pa,pb=pb,pa
        parents[pb]=pa
        size[pa]+=size[pb]
        return size[pa]
    for a,b in infos:
        if a not in names:
            names[a]=order
            order+=1
        if b not in names:
            names[b]=order
            order+=1
        cnt=union(names[a],names[b])
        ans.append(cnt)
print("\n".join(map(str,ans)))
