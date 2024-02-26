import sys

while True:
    num_list = list(map(int, sys.stdin.readline().split()))
    if num_list == [0, 0, 0]:
        break

    max_num = max(num_list)
    num_list.remove(max_num)
    if max_num ** 2 == num_list[0] ** 2 + num_list[1] ** 2:
        print("right")
    else:
        print("wrong")