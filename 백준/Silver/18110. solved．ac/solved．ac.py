import sys

n = int(sys.stdin.readline())

if n:
    difficulty = []
    for _ in range(n):
        difficulty.append(int(sys.stdin.readline()))

    difficulty.sort()

    k = n * 0.15
    if k - (k // 1) < 0.5:
        k //= 1
    else:
        k = (k // 1) + 1
    k = int(k)

    score = 0
    for i in range(k, n - k):
        score += difficulty[i]

    avr = score / (n - (k * 2))
    if avr - (avr // 1) < 0.5:
        avr //= 1
    else:
        avr = (avr // 1) + 1
    avr = int(avr)
    print(avr)
else:
    print(0)