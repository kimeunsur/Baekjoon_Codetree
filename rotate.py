board= [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]

# 시계 방향으로 90도 회전
def rotate_right_90(board):
    n=len(board)
    m=len(board[0])
    new_board=[[0]*n for _ in range(m)]
    for i in range(n):
        for j in range (m):
            new_board[j][n-1-i] = board[i][j]
    return new_board

# 반시계 방향으로 90도 회전
def rotate_left_90(board):
    n=len(board)
    m=len(board[0])
    new_board=[[0]*n for _ in range(m)]
    for i in range(n):
        for j in range(m):
            new_board[m-1-j][i]=board[i][j]
    return new_board

# 출력 함수
def print_board(board):
    l=len(board)
    for i in range (l):
        print(board[i])
    print()


print_board(board) # 기본

new_board = rotate_right_90(board)
print_board(new_board) # 시계 방향으로 90도 회전

new_board = rotate_left_90(board)
print_board(new_board) # 반시계 방향으로 90도 회전
