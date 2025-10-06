import sys
input=sys.stdin.readline
n=int(input().strip())
l=[tuple(map(int,input().split())) for _ in range (n)]
l.sort(key=lambda x:x[1])
import heapq
q=[]
for p,d in l:
    heapq.heappush(q,p)
    if len(q)>d:
        heapq.heappop(q)
print(sum(q))
