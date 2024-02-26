import sys

n, m = map(int, sys.stdin.readline().split())

matrix = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

prefix_matrix = [[0 for _ in range(n+1)] for _ in range(n+1)]

for x in range(n):
    for y in range(n):
        prefix_matrix[x+1][y+1] = prefix_matrix[x+1][y] + prefix_matrix[x][y+1] - prefix_matrix[x][y] + matrix[x][y]

for i in range(m):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    print(prefix_matrix[x2][y2] - prefix_matrix[x2][y1-1] - prefix_matrix[x1-1][y2] + prefix_matrix[x1-1][y1-1])