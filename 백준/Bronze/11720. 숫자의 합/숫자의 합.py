import sys

n = int(sys.stdin.readline())
numbers = sys.stdin.readline().rstrip()

sum = 0
for i in range(n):
    sum += int(numbers[i])

print(sum)