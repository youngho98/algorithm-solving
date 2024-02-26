import sys

n, m = map(int, sys.stdin.readline().split())

lst = []
def recur(count):
    if count == m:
        print(*lst)
        return
    
    for i in range(1, n + 1):
        if i in lst:
            continue
        lst.append(i)
        recur(count + 1)
        lst.pop()

recur(0)