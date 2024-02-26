from collections import deque
import sys

n = int(sys.stdin.readline())
deq = deque()

for _ in range(n):
    command = sys.stdin.readline().split()
    if command[0] == "push_front":
        deq.appendleft(int(command[1]))
    elif command[0] == "push_back":
        deq.append(int(command[1]))
    elif command[0] == "pop_front":
        if deq:
            print(deq.popleft())
        else:
            print(-1)
    elif command[0] == "pop_back":
        if deq:
            print(deq.pop())
        else:
            print(-1)
    elif command[0] == "size":
        print(len(deq))
    elif command[0] == "empty":
        if not deq:
            print(1)
        else:
            print(0)
    elif command[0] == "front":
        if deq:
            print(deq[0])
        else:
            print(-1)
    else:
        if deq:
            print(deq[-1])
        else:
            print(-1)