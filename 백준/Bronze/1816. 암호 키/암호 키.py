import sys

n = int(sys.stdin.readline())

for i in range(n):
    available = True
    s = int(sys.stdin.readline())
    for j in range(2, 1000001):
        if s % j == 0:
            available = False
    
    if available:
        print("YES")
    else:
        print("NO")