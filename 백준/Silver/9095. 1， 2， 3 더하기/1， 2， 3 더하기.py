import sys

t = int(sys.stdin.readline())

num = [int(sys.stdin.readline()) for _ in range(t)]

def recur(idx, n):
    global count
    if idx == n:
        count += 1
        return
    elif idx > n:
        return
    else:
        recur(idx + 1, n)
        recur(idx + 2, n)
        recur(idx + 3, n)

for i in range(t):
    count = 0
    recur(0, num[i])
    print(count)