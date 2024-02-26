import sys

n = int(sys.stdin.readline())
mp, mf, ms, mv = map(int, sys.stdin.readline().split())
ingr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

cost = 7501
lst = []
nums = []

def recur(idx, p, f, s, v, c, bi):
    global cost
    global num
    if idx == n:
        if p >= mp and f >= mf and s >= ms and v >= mv:
            if c <= cost:
                cost = c
                nums.append(bi)
        return

    recur(idx + 1, p + ingr[idx][0], f + ingr[idx][1], s + ingr[idx][2], v + ingr[idx][3], c + ingr[idx][4], bi + 2 ** idx)

    recur(idx + 1, p, f, s, v, c, bi)

def binary(num):
    bi_lst = []
    i = 15
    while i >= 0:
        if num >= 2 ** i:
            bi_lst.append(i + 1)
            num -= 2 ** i
        i -= 1
    bi_lst.sort()
    return bi_lst

recur(0, 0, 0, 0, 0, 0, 0)
nums = []
recur(0, 0, 0, 0, 0, 0, 0)
if cost == 7501:
    print(-1)
else:
    print(cost)
    answer = []
    for i in range(len(nums)):
        answer.append(binary(nums[i]))
    answer.sort()
    answer = answer[0]
    print(*answer)