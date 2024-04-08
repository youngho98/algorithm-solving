k, n, m = map(int, input().split())
ans = k * n - m
if ans < 0:
    ans = 0
print(ans)