import sys

n, m = map(int, sys.stdin.readline().split())
nums = list(map(int,sys.stdin.readline().split()))
nums.sort()

lst = []

def recur(count):
  if count == m:
    print(*lst)

  for i in nums:
    if lst:
      if i <= lst[-1]:
        continue
    lst.append(i)
    recur(count + 1)
    lst.pop()

recur(0)    