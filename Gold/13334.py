import sys
input=sys.stdin.readline
n=int(input().strip())
pair=[list(map(int,input().split())) for _ in range(n)]
d=int(input().strip())
segment=[]
for h,o in pair:
    if h-o<=d:
        if h>o:
            segment.append((o,h))
        else:
            segment.append((h,o))
segment.sort(key=lambda x:x[1])

import heapq
q=[]
best=0
for s,e in segment:
    L=e-d
    heapq.heappush(q,s)
    while q and q[0]<L:
        heapq.heappop(q)
    if len(q)>best:
        best=len(q)
print(best)
        
