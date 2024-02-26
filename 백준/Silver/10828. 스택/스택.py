import sys

n = int(sys.stdin.readline())

stack = []

for _ in range(n):
    order = sys.stdin.readline().rstrip()
    if order == "pop":
        if stack:
            print(stack.pop())
        else:
            print(-1)
    elif order == "size":
        print(len(stack))
    elif order == "empty":
        if stack:
            print(0)
        else:
            print(1)
    elif order == "top":
        if stack:
            print(stack[-1])
        else:
            print(-1)
    else:
        push, num = order.split()
        stack.append(int(num))