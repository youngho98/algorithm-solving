import sys

n = int(sys.stdin.readline())

time = list(map(int, sys.stdin.readline().split()))
time.sort()

sum_time = 0
for i in range(n):
    sum_time += time[i] * (n - i)

print(sum_time)