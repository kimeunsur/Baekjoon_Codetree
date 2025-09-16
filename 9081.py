t=int(input())
words=[input() for _ in range (t)]
for word in words:
    l=len(word)
    w=list(word)
    done=False
    for i in range(l-1,0,-1):
        if w[i]>w[i-1]:
            for j in range(l-1,i-1,-1):
                if w[i-1]<w[j]:
                    w[i-1],w[j]=w[j],w[i-1]
                    w[i:]=sorted(w[i:])
                    done=True
                    break
        if done:
            break
    print("".join(w))
