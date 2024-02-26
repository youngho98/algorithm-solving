import sys

n = int(sys.stdin.readline())

dp = [0 for _ in range(1_000_001)]

for i in range(2, n + 1):
    if i % 3 == 0:
        if i % 2 == 0:
            dp[i] = min(dp[i-1], dp[i//2], dp[i//3]) + 1
        else:
            dp[i] = min(dp[i-1], dp[i//3]) + 1
    else:
        if i % 2 == 0:
            dp[i] = min(dp[i-1], dp[i//2]) + 1
        else:
            dp[i] = dp[i-1] + 1

print(dp[n])