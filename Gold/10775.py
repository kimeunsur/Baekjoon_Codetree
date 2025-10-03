import sys
input=sys.stdin.readline

g=int(input())
p=int(input())
planes=[int(input()) for _ in range(p)]
docked=[i for i in range(g+1)]

def find(n):
    if docked[n]!=n:
        n=find(docked[n])
    return n
cnt=0
for i,plane in enumerate(planes):
    j=find(plane)
    print('찾은거:',j)
    if j==0:
        print(cnt)
        break
    docked[j]=find(j-1)
    cnt+=1
    
