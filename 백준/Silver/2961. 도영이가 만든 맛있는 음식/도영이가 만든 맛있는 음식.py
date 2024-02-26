import sys

n = int(sys.stdin.readline())

ingredients = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

answer = 1_000_000_001
def recur(num, s, b, count):
    global answer

    if num == n:
        if count == 0:
            return
        
        gap = abs(s - b)
        if gap < answer:
            answer = gap
        return
    
    recur(num + 1, s * ingredients[num][0], b + ingredients[num][1], count + 1)

    recur(num + 1, s, b, count)

recur(0, 1, 0, 0)

print(answer)