def solution(N, stages):
    users=[0]*(N+2)
    for stage in stages:
        users[stage]+=1
    total=len(stages)
    fail={}
    for i in range(1,N+1):
        if users[i]==0:
            fail[i]=0.0
        else:
            fail[i]=float(users[i])/float(total)
            total-=users[i]
    result=sorted(fail.keys(),key=lambda x:fail[x], reverse=True)
    return result
