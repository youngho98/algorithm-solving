import sys

n, k = map(int ,sys.stdin.readline().split())
temp = list(map(int, sys.stdin.readline().split()))

prefix = [0 for i in range(n + 1)]

for i in range(n):
    prefix[i + 1] = temp[i] + prefix[i]

max = -10_000_001
for j in range(k, n + 1):
    if prefix[j] - prefix[j - k] > max:
        max = prefix[j] - prefix[j - k]
print(max)