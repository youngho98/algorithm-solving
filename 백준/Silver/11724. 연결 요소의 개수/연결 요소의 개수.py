from collections import deque
import sys

n, m = map(int, sys.stdin.readline().split())

connect = [[] for _ in range(n + 1)]
visited = [0 for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    connect[a].append(b)
    connect[b].append(a)

q = deque()
count = 0
for i in range(1, n + 1):
    if visited[i] == 0:
        q.append(i)
        count += 1
        visited[i] = 1
        while q:
            node = q.popleft()
            for n in connect[node]:
                if visited[n] == 0:
                    q.append(n)
                    visited[n] = 1

print(count)