import sys

n = int(sys.stdin.readline())

# 인덱스 값에 높이 설정
graph = [0 for _ in range(1002)]

for _ in range(n):
    l, h = map(int, sys.stdin.readline().split())
    graph[l] = h

# 왼쪽에서부터 넓이 합
i = 1
l = 0
area = 0
while graph[i] < max(graph):
    if graph[l] < graph[i]:
        l = i
    area += graph[l]
    i += 1

# 오른쪽에서부터 넓이 합
j = 1000
l = 1001
while graph[j] < max(graph):
    if graph[l] < graph[j]:
        l = j
    area += graph[l]
    j -= 1

# 가장 높은 지점들 사이의 넓이
area += graph[i] * (j - i + 1)

# 최종 출력
print(area)