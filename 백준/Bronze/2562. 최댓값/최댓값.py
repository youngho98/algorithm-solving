import sys

num_list = []

for i in range(9):
    num_list.append(int(sys.stdin.readline()))

max_num = num_list[0]
max_index = 0

for i in range(1, 9):
    if num_list[i] > max_num:
        max_num = num_list[i]
        max_index = i
max_index += 1

print(max_num)
print(max_index)