import sys

n = int(sys.stdin.readline())
list_a = list(map(int, sys.stdin.readline().split()))
v = int(sys.stdin.readline())

count = 0

for i in list_a:
    if i == v:
        count += 1

print(count)