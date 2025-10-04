import sys
input=sys.stdin.readline
n,k,a,b=map(int,input().split())
pots=[k]*n
m=0
day=0
while True:
    day+=1
    # 1
    for i in range(m,m+a):
        pots[i%n]+=b
    # 2
    pots=[x-1 for x in pots]
    m=min(enumerate(pots), key=lambda x:x[1])[0]
    # 3
    if any(x<=0 for x in pots):
        print(day)
        break
