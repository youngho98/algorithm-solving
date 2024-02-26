import sys

a, b = map(int, sys.stdin.readline().rstrip().split())

if a > b:
    print(">")
elif a < b:
    print("<")
else:
    print("==")