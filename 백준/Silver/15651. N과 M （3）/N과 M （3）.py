n, m = map(int, input().split())

lst = []

def recur(count):
    if count == m:
        print(" ".join(map(str, lst)))
        return
    
    for i in range(1, n + 1):
        lst.append(i)
        recur(count + 1)
        lst.pop()

recur(0)