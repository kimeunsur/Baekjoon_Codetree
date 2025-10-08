import sys
from collections import defaultdict
input=sys.stdin.readline
n,m=map(int,input().split())
l=[list(map(int,input().split())) for _ in range(n)]
segment=[]
for s,e in l:
    if s>e:
        segment.append((e,s))
segment.sort()
total=0
cs,ce=-1,-1
for s,e in segment:
    if cs==-1:
        cs,ce=s,e
    elif s<=ce:
        ce=max(ce,e)
    elif s>ce:
        total+=(ce-cs)
        cs,ce=s,e
total+=(ce-cs)
print(m+total*2)
