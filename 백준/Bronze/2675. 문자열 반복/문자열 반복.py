import sys

t = int(sys.stdin.readline())

for i in range(t):
    repeat, word = sys.stdin.readline().split()
    repeat = int(repeat)
    for char in word:
        print(char * repeat, end = "")
    print()