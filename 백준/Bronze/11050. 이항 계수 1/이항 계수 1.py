import sys

n, k = map(int, sys.stdin.readline().split())

def factorial(a):
    factorial = 1
    for i in range(1, a + 1):
        factorial *= i
    return factorial

print(factorial(n) // (factorial(k) * factorial(n - k)))