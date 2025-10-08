import sys
input=sys.stdin.readline
n=int(input().strip())
l=list(map(int,input().split()))
min_x=float('inf')
best=0
for i in range(len(l)):
    min_x=min(min_x,l[i])
    best=max(best,l[i]-min_x)
print(best)
