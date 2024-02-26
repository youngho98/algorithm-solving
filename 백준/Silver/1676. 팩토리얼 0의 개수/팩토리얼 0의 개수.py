def fac(num):
    result = 1
    for i in range(1, num + 1):
        result *= i
    return result

def find0(num):
    count = 0
    while num % 10 == 0:
        count += 1
        num //= 10
    return count

n = int(input())

print(find0(fac(n)))