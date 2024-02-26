import sys

n, k = map(int, sys.stdin.readline().split())

arr = [i for i in range(1, n + 1)]
arr2 = []

def index_check(index):
    while True:
        if index < 0:
            index += len(arr)
        elif index > len(arr) - 1:
            index -= len(arr)
        else:
            break
    return index

remove = 0
while arr:
    remove += k - 1
    remove = index_check(remove)
    arr2.append(arr.pop(remove))

print("<", end = "")
print(*arr2, sep =", ", end = "")
print(">")