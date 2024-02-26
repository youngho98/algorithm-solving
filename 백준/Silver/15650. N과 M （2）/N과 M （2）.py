n, m = map(int, input().split())

lst = []

def recur(count):
    if count == m:
        print(*lst)
        return
    
    for i in range(1, n + 1):
        if lst:
            if i <= lst[-1]:
                continue
        lst.append(i)
        recur(count + 1)
        lst.pop()
    
recur(0)