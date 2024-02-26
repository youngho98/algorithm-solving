import sys

raw_input = sys.stdin.readlines()
for line in raw_input:
    print(line.rstrip())