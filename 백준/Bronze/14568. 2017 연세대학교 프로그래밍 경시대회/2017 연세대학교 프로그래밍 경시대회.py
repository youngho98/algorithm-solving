import sys

n = int(sys.stdin.readline())

count = 0
for a in range(1, n - 1):
    for b in range(1, n - 1):
        for c in range(1, n - 1):
            if a + b + c == n:
                if c >= b + 2:
                    if a % 2 == 0:
                        count += 1

print(count)