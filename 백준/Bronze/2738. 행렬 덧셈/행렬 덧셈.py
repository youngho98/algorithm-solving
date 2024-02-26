import sys

n, m = map(int, sys.stdin.readline().split())

matrix_a = []
matrix_b = []

for i in range(n):
    matrix_a.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    matrix_b.append(list(map(int, sys.stdin.readline().split())))

for i in range(n):
    for j in range(m):
        print(matrix_a[i][j] + matrix_b[i][j], end = " ")
    print()