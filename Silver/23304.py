import sys
input=sys.stdin.readline
s=input().strip()

def reversed(s):
    return s==s[::-1]

def pallendrom(s):
    n=len(s)
    if n<=1:
        return True
    if not reversed(s):
        return False
    k=n//2
    if n%2==0:
        return pallendrom(s[:k]) and pallendrom(s[k:])
    else:
        return pallendrom(s[:k]) and pallendrom(s[k+1:])
    
print("AKARAKA" if pallendrom(s) else "IPSELENTI")
