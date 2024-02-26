import sys

n = int(sys.stdin.readline())
house = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[0] * 3 for _ in range(n + 1)]
for i in range(1, n + 1):
    for color in range(3):
        if color == 0:
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + house[i - 1][0]
        elif color == 1:
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + house[i - 1][1]
        else:
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + house[i - 1][2]
            
print(min(dp[n][0], dp[n][1], dp[n][2]))