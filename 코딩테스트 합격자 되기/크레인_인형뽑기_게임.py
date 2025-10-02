def solution(board, moves):
    moves=[move-1 for move in moves]
    n=len(board)
    stack=[]
    score=0
    for move in moves:
        num=-1
        for i in range(n):
            if board[i][move]!=0:
                num=board[i][move]
                board[i][move]=0
                break
        if num==-1:
            continue
        if stack and (stack[-1]==num):
            score+=2
            stack.pop()
        else:
            stack.append(num)
    return score
        
