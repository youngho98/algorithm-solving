import sys

n = int(sys.stdin.readline())

for i in range(1, 10):
    print("{0} * {1} = {2}".format(n, i, n * i))