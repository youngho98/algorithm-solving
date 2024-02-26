import sys

word = sys.stdin.readline().rstrip()

for i in word:
    if ord(i) <= 90:
        print(i.lower(), end = "")
    else:
        print(i.upper(), end = "")