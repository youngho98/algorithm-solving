import sys

def dfs(n, r, c):
    if n == 0:
        return 0
    if r < 2 ** (n-1):
        if c < 2 ** (n-1):
            return dfs(n-1, r, c)
        else:
            return dfs(n-1, r, c - 2 ** (n-1)) + (2 ** (n-1)) ** 2
    else:
        if c < 2 ** (n-1):
            return dfs(n-1, r - 2 ** (n-1), c) + ((2 ** (n-1)) ** 2) * 2
        else:
            return dfs(n-1, r - 2 ** (n-1), c - 2 ** (n-1)) + ((2 ** (n-1)) ** 2) * 3

n, r, c = map(int, sys.stdin.readline().split())

print(dfs(n, r, c))