def gcd(a, b):
    while a % b != 0:
        mod = a % b
        a = b
        b = mod
    return b

import sys

g, l = map(int, sys.stdin.readline().split())

div = l // g

num = 0
for a in range(int(div ** 0.5), 0, -1):
    if div % a == 0:
        if gcd(div/a, a) == 1:
            num = a
            break

print(num * g, div // num * g)