import sys

n, x = map(int, sys.stdin.readline().split())
list_a = list(map(int, sys.stdin.readline().split()))
output = []

for i in range(n):
    if list_a[i] < x:
        output.append(list_a[i])

print(*output)