arr = list(map(int, input().split()))
arr.sort()
print(abs(arr[0] + arr[3] - arr[1] - arr[2]))