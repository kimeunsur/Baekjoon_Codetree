n = int(input())
moves = [tuple(input().split()) for _ in range(n)]
dir = [move[0] for move in moves]
dist = [int(move[1]) for move in moves]
x,y=0,0
dxy=[(-1,0),(1,0),(0,-1),(0,1)] # W E S N
dic = {'W':0, 'E':1, 'S':2, 'N':3}
for i in range(n):
    d = dic[dir[i]]
    w = dist[i]
    for j in range(w):
        x+=dxy[d][0]
        y+=dxy[d][1]
    
print(x,y)
