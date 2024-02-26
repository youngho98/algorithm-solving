import sys

a, b = map(int, sys.stdin.readline().split())

g = 0
for i in range(1, min(a, b) + 1):
    if a % i == 0 and b % i == 0:
        if i > g:
            g = i

l = 0
i = 1
while True:
    if (max(a, b) * i) % min(a, b) == 0:
        l = max(a, b) * i
        break
    else: i += 1

print(g)
print(l)