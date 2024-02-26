import sys

n, m = map(int, sys.stdin.readline().split())
no_listen = set([sys.stdin.readline().rstrip() for _ in range(n)])
no_see = set([sys.stdin.readline().rstrip() for _ in range(m)])

answer_list = list(no_listen & no_see)
answer_list.sort()

print(len(answer_list))
for name in answer_list:
    print(name)