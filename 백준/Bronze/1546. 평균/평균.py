import sys

n = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split()))

print(sum(score) / max(score) / n * 100)