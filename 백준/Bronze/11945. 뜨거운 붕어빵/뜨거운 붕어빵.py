n, m = map(int, input().split())
list = [list(input()) for _ in range(n)]
for i in range(n):
    for j in range(m - 1, -1, -1):
        print(list[i][j], end = "")
    print()