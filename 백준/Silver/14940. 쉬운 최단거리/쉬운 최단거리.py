from collections import deque
import sys
input = sys.stdin.readline

def bfs(a, b):
    q = deque([[a, b]])
    while q:
        [nx, ny] = q.popleft()
        for x, y in [[nx+1, ny], [nx-1, ny], [nx, ny+1], [nx, ny-1]]:
            if 0 <= x < n and 0 <= y < m and not visited[x][y]:
                if graph[x][y] == 1:
                    dist[x][y] = dist[nx][ny] + 1
                    q.append([x, y])
                    visited[x][y] = True

n, m = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dist = [[0 for _ in range(m)] for _ in range(n)]
visited = [[False for _ in range(m)] for _ in range(n)]

# 목표지점 찾기
a, b = 0, 0
loop_esc = False
for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            loop_esc = True
            a, b = i, j
            break
    if loop_esc:
        break

# BFS 탐색
visited[a][b] = True
bfs(a, b)

# 갈 수 있는 땅 중에서 도달할 수 없는 곳 -1 표시
for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and dist[i][j] == 0:
            dist[i][j] = -1

# 출력
for di in dist:
    print(*di)