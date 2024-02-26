import sys

n = int(sys.stdin.readline())

for _ in range(n):
    ps = sys.stdin.readline()
    left = []
    right = []
    check = True

    for x in ps:
        if x == "(":
            left.append(x)
        if x == ")":
            right.append(x)
        if len(left) < len(right):
            check = False

    if len(left) != len(right):
        check = False

    if check:
        print("YES")
    else:
        print("NO")