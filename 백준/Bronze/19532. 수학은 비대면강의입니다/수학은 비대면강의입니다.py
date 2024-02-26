import sys

a, b, c, d, e, f = map(int, sys.stdin.readline().split())

for x in range(-999, 1000):
    for y in range(-999, 1000):
        if a * x + b * y == c:
            if d * x + e * y == f:
                print(x, y)