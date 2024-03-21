def quadTree(n, x, y):
    one = False
    zero = False
    for i in range(x, x + n):
        for j in range(y, y + n):
            if arr[i][j] == 1:
                one = True
            elif arr[i][j] == 0:
                zero = True

    if (one and not zero):
        print(1, end="")
        return
    if (not one and zero):
        print(0, end="")
        return

    print("(", end="")
    quadTree(n // 2, x, y)
    quadTree(n // 2, x, y + n // 2)
    quadTree(n // 2, x + n // 2, y)
    quadTree(n // 2, x + n // 2, y + n // 2)
    print(")", end="")

N = int(input())
arr = [list(map(int, input())) for _ in range(N)]
quadTree(N, 0, 0)