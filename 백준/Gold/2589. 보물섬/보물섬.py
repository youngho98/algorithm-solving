from collections import deque
import sys

X, Y = map(int, sys.stdin.readline().split())
graph = [list(sys.stdin.readline().rstrip()) for _ in range(X)]

maxi = 0
for x in range(X):
    for y in range(Y):
        if graph[x][y] == "L":
            q = deque()
            visited = [[0 for _ in range(Y)] for _ in range(X)]
            dist = [[0 for _ in range(Y)] for _ in range(X)]

            q.append([x, y])
            visited[x][y] = 1

            while q:
                ex, ey = q.popleft()

                for dx, dy in [[0,1], [1,0], [0,-1], [-1,0]]:
                    nx, ny = ex + dx, ey + dy
                    if 0 <= nx < X and 0 <= ny < Y:
                        if graph[nx][ny] == "L":
                            if visited[nx][ny] == 0:
                                dist[nx][ny] = dist[ex][ey] + 1
                                q.append([nx, ny])
                                visited[nx][ny] = 1
                                maxi = max(maxi, dist[nx][ny])

print(maxi)