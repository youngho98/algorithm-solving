from collections import deque

n, k = map(int, input().split())

q = deque([n])
dist = [-1 for _ in range(100_001)]
dist[n] = 0
escape = False
if n == k:
    print(dist[n])
else:
    while q:
        node = q.popleft()
        for x in [node - 1, node + 1, node * 2]:
            if 0 <= x <= 100_000 and dist[x] == -1:
                q.append(x)
                dist[x] = dist[node] + 1
                if x == k:
                    print(dist[x])
                    escape = True
                    break
        if escape:
            break