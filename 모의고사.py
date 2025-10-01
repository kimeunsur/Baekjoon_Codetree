def solution(answer):
    ans=len(answer)
    patterns=[
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    result=[0]*3
    for i in range(3):
        score=0
        n=len(patterns[i])
        for j in range(ans):
            if patterns[i][j%n]==answer[j]:
                score+=1
        result[i]=score
    
    winner=[]
    max_score=max(result)
    for i,score in enumerate(result):
        if score==max_score:
            winner.append(i+1)
    return winner
