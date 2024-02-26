import sys

n, m = map(int, sys.stdin.readline().split())

board = []
for _ in range(n):
    line = sys.stdin.readline().rstrip()
    lst = []
    for word in line:
        lst.append(word)
    board.append(lst)

max = 0
for i in range(n - 7):
    for j in range(m - 7):
        count = 0
        for k in range(0, 7, 2):
            for l in range(0, 7, 2):
                if board[i][j] == board[i+k][j+l]:
                    count += 1
                if board[i][j] != board[i+k][j+l+1]:
                    count += 1
            for l in range(0, 7, 2):
                if board[i][j] != board[i+k+1][j+l]:
                    count += 1
                if board[i][j] == board[i+k+1][j+l+1]:
                    count += 1
        if count < 32:
            count = 64 - count
        if count > max:
            max = count
print(64 - max)