import sys

n, m = map(int, sys.stdin.readline().split())

dict_num = dict()

for i in range(1, n + 1):
    dict_num[i] = sys.stdin.readline().rstrip()

dict_name = {v : k for k, v in dict_num.items()}

for _ in range(m):
    question = sys.stdin.readline().rstrip()
    try:
        print(dict_num[int(question)])
    except:
        print(dict_name[question])