import sys

n, k = map(int, sys.stdin.readline().split())

prod = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[-1 for _ in range(k + 1)] for _ in range(n + 1)]

def recur(idx, weight):
    if weight > k:
        return -9999999
    
    if idx == n:
        return 0
    
    if dp[idx][weight] != -1:
        return dp[idx][weight]
    
    dp[idx][weight] = max(recur(idx + 1, weight + prod[idx][0]) + prod[idx][1], recur(idx + 1, weight))

    return dp[idx][weight]

print(recur(0, 0))