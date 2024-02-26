import sys

n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))

count_plus = [0] * (10_000_001)
count_minus = [0] * (10_000_001)

for i in n_list:
    if i < 0:
        count_minus[-i] += 1
    else:
        count_plus[i] += 1

for i in m_list:
    if i < 0:
        print(count_minus[-i], end = " ")
    else:
        print(count_plus[i], end = " ")