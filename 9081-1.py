t=int(input())

def next_one(word):
    letters=list(word)
    l=len(word)
    i=l-2
    while i>=0 and letters[i]>=letters[i+1]:
        i-=1
    if i<0:
        return word
    j=l-1
    while letters[j]<=letters[i]:
        j-=1
    letters[i], letters[j] = letters[j], letters[i]
    
    suffix=letters[i+1:]
    suffix.sort()
    result=letters[:i+1]+suffix
    return "".join(result)

words=[input().strip() for _ in range(t)]
for word in words:
    print(next_one(word))
