import sys

n = int(sys.stdin.readline())

lst = [sys.stdin.readline().split() for _ in range(n)]
lst.sort(key = lambda x: int(x[0]))

for i in range(n):
    print(*lst[i])