import sys

t = int(sys.stdin.readline())

for i in range(t):
    word = sys.stdin.readline().rstrip()
    print(word[0], word[-1], sep = "")