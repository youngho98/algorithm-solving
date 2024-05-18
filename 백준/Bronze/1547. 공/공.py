m = int(input())

now = 1
for i in range(m):
    x, y = map(int, input().split())
    if (x == now):
        now = y
    elif (y == now):
        now = x

print(now)