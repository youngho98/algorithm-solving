import sys

n = int(sys.stdin.readline())
interview = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [-1 for _ in range(n + 1)]
def recur(idx):
    if idx == n + 1:
        return 0
    
    elif idx > n + 1:
        return -99999999
    
    elif dp[idx] != -1:
        return dp[idx]
    
    else:
        # 상담 O
        dp[idx] = max(recur(idx + interview[idx - 1][0]) + interview[idx - 1][1], recur(idx + 1))
        return dp[idx]

print(recur(1))