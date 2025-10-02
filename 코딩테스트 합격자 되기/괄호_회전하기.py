def solution(s):
    def is_possible(s):
        twin={"(":")","{":"}","[":"]"}
        stack=[]
        for a in s:
            if a=='(' or a=='{' or a=='[':
                stack.append(a)
            else:
                if not stack:
                    return False
                top=stack.pop()
                if twin[top]!=a:
                    return False
        if stack:
            return False
        else:
            return True
    cnt=0
    for i in range(len(s)):
        ns=s[i+1:]+s[:i+1]
        if is_possible(ns):
            cnt+=1
    return cnt
