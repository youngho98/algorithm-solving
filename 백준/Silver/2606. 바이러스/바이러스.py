import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

connect = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]

virus = {1}
for _ in range(m):
    for con in connect:
        if con[0] in virus:
            virus.add(con[1])
        elif con[1] in virus:
            virus.add(con[0])

print(len(virus) - 1)