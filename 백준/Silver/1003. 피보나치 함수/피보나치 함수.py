import sys

t = int(sys.stdin.readline())

dp = [0 for _ in range(41)]
dp[1] = 1

for _ in range(t):
    n = int(sys.stdin.readline())
    if n == 0:
        print(1, 0)
    else:
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        print(dp[n - 1], dp[n])