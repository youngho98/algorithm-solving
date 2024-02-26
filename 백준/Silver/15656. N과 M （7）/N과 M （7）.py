import sys

n, m = map(int, sys.stdin.readline().split())
nums = list(map(int,sys.stdin.readline().split()))
nums.sort()

lst = []

def recur(count):
  if count == m:
    print(*lst)
    return

  for i in nums:
    lst.append(i)
    recur(count + 1)
    lst.pop()

recur(0)