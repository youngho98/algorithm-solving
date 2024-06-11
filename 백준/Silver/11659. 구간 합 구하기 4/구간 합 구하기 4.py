import sys

n, m = map(int, sys.stdin.readline().split())
lst = list(map(int, sys.stdin.readline().split()))

prefix = [0 for _ in range(n + 1)]

for i in range(n):
    prefix[i + 1] = prefix[i] + lst[i]

for k in range(m):
    i, j = map(int, sys.stdin.readline().split())
    print(prefix[j] - prefix[i - 1])