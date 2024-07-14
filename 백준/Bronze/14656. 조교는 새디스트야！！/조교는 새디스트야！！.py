n = int(input())
lst = list(map(int, input().split()))
cnt = 0
for i in range(n):
    if (lst[i] != i + 1):
        cnt += 1
print(cnt)