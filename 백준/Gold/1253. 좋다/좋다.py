import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
lst.sort()

count = 0
for i in range(0, n):
    x = 0
    y = n - 1
    while x != y:
        if x == i or lst[x] + lst[y] < lst[i]:
            x += 1
        elif y == i or lst[x] + lst[y] > lst[i]:
            y -= 1
        else:
            count += 1
            break

print(count)