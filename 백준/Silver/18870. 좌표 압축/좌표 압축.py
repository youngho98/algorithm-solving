import sys

n = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
sort_lst = sorted(list(set(lst)))

dict = dict()
for i in range(len(sort_lst)):
    dict[sort_lst[i]] = i

for point in lst:
    print(dict[point], end = " ")