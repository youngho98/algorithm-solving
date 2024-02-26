import sys

n = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))

prefix = [0] * (n + 1)

for i in range(n):
    prefix[i + 1] = max(prefix[i] + arr[i], arr[i])

prefix.pop(0)

print(max(prefix))