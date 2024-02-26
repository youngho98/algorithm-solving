import sys

sys.setrecursionlimit = 10 ** 5

def dfs(a, b, n):
    if n == 1:
        if graph[a][b] == 0:
            check[0] += 1
        else:
            check[1] += 1
        return

    diff = False
    for i in range(n):
        for j in range(n):
            if graph[a][b] != graph[a + i][b + j]:
                diff = True
    
    if diff:
        dfs(a, b, n//2)
        dfs(a + n//2, b, n//2)
        dfs(a, b + n//2, n//2)
        dfs(a + n//2, b + n//2, n//2)
    else:
        if graph[a][b] == 0:
            check[0] += 1
        else:
            check[1] += 1
        return

n = int(sys.stdin.readline())

graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
check = [0, 0]
dfs(0, 0, n)

print(check[0])
print(check[1])