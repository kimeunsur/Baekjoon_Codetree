def solution(s):
    stack=[]
    for a in s:
        if a=='(':
            stack.append(a)
        elif a==')':
            if not stack:
                return False
            else:
                stack.pop()
    if len(stack)==0:
        return True
    else:
        return False
