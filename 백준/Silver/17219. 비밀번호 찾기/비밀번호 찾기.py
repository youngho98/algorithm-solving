import sys

n, m = map(int, sys.stdin.readline().split())
password = dict()
for _ in range(n):
    site, pw = sys.stdin.readline().split()
    password[site] = pw

for _ in range(m):
    question = sys.stdin.readline().rstrip()
    print(password[question])