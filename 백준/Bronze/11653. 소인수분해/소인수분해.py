import sys

number = int(sys.stdin.readline())

for i in range(2, number + 1):
    while number % i == 0:
        print(i)
        number //= i