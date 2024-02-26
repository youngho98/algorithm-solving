import sys

n, k = map(int, sys.stdin.readline().split())

arr = [i for i in range(1, n + 1)]
arr2 = []

index = 0
while arr:
    index += k - 1
    while True:
        if index > len(arr) - 1:
            index -= len(arr)
        else:
            break
    arr2.append(arr.pop(index))

print("<", end = "")
print(*arr2, sep =", ", end = "")
print(">")