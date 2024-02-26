import sys

n = int(sys.stdin.readline())
n_lst = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_lst = list(map(int, sys.stdin.readline().split()))

n_lst.sort()

for num in m_lst:
    left, right = 0, n - 1
    check = False

    while left < right:
        mid = (left + right) // 2
        if num < n_lst[mid]:
            right = mid - 1
        elif num > n_lst[mid]:
            left = mid + 1
        else:
            check = True
            break
    if n_lst[left] == num:
        check = True
    
    if check:
        print(1)
    else:
        print(0)