def tiling(n):
    if dp[n] != 0:
        return dp[n]
    elif dp[n - 1] != 0:
        dp[n] = dp[n - 1] + dp[n - 2] * 2
        return dp[n]
    else:
        for i in range(dp.index(0, 1), n + 1):
            dp[i] = dp[i - 1] + dp[i - 2] * 2
        return dp[n]
    
dp = [0 for _ in range(251)]
dp[0] = 1
dp[1] = 1
dp[2] = 3

while True:
    try:
        n = int(input())
        print(tiling(n))
    except:
        break