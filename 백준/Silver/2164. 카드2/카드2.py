from collections import deque

n = int(input())

deq = deque([i + 1 for i in range(n)])

while len(deq) > 1:
    deq.popleft()
    deq.rotate(-1)

print(deq[0])