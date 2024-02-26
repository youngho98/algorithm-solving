import sys

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

count = 0
for i in range(n):
    is_prime = True
    if nums[i] == 1:
        continue

    for j in range(2, nums[i]):
        if nums[i] % j == 0:
            is_prime = False
        
    if is_prime == True:
        count += 1

print(count)