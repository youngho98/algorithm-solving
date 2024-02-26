import sys

n = int(sys.stdin.readline())
lst = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

lst.sort()
lst.sort(key= lambda x: x[1])
for l in lst:
    print(*l)