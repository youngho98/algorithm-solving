import sys
sys.setrecursionlimit(1_000_000)

def connect(i, j, adjoin):
    field[i][j] = 0
    while adjoin:
        if field[i - 1][j] == 1:
            connect(i - 1, j, True)
        elif field[i + 1][j] == 1:
            connect(i + 1, j, True)
        elif field[i][j - 1] == 1:
            connect(i, j - 1, True)
        elif field[i][j + 1] == 1:
            connect(i, j + 1, True)
        else:
            adjoin = False
            return

t = int(sys.stdin.readline())

for _ in range(t):
    m, n, k = map(int, sys.stdin.readline().split())
    field = [[0 for _ in range(n + 2)] for _ in range(m + 2)]
    for _ in range(k):
        x, y = map(int, sys.stdin.readline().split())
        field[x + 1][y + 1] = 1

    count = 0
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if field[i][j] == 1:
                count += 1
                connect(i, j, True)
                
    print(count)