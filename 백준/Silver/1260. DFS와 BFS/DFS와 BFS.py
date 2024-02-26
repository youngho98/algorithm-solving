import sys
from collections import deque

def dfs(node):
    if visited[node]:
        return
    visited[node] = True
    dfs_list.append(node)
    for i in graph[node]:
        dfs(i)

def bfs(node):
    deq.append(node)
    visited[node] = True
    while deq:
        n = deq.popleft()
        bfs_list.append(n)
        for i in graph[n]:
            if visited[i]:
                continue
            deq.append(i)
            visited[i] = True

n, m, v = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, n + 1):
    graph[i].sort()

dfs_list = []
visited = [False for _ in range(n + 1)]
dfs(v)

bfs_list = []
visited = [False for _ in range(n + 1)]
deq = deque()
bfs(v)

print(*dfs_list)
print(*bfs_list)