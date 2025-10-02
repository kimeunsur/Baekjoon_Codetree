def solution(arr1, arr2):
    m=len(arr1)
    n=len(arr1[0])
    p=len(arr2[0])
    result=[[0]*p for _ in range(m)]
    for i,arr_1 in enumerate(arr1):
        for j in range(p):
            sum=0
            for l in range(n):
                sum+=arr_1[l]*arr2[l][j]
            result[i][j]=sum
    return result
