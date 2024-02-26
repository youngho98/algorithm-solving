# f(1) + f(2) + ... + f(a)의 값을 구하는 함수
def func(num):
    sum = num
    i = 1
    while num >= 2 ** i:
        sum += (int(num / (2 ** i))) * ((2 ** i) - (2 ** (i - 1)))
        i += 1
    return sum

# 입출력
import sys

a, b = map(int, sys.stdin.readline().split())

print(func(b) - func(a - 1))