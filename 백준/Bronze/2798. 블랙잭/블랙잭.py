import sys

n, m = map(int, sys.stdin.readline().split())
cards = list(map(int, sys.stdin.readline().split()))

sum = 0
for i in range(2, n):
    for j in range(1, i):
        for k in range(0, j):
            if sum < cards[i] + cards[j] + cards[k] <= m:
                sum = cards[i] + cards[j] + cards[k]

print(sum)