import sys

h, m = map(int, sys.stdin.readline().split())

if m - 45 < 0:
    m += 15
    h -= 1
    if h < 0:
        h += 24
else:
    m -= 45

print(h, m)