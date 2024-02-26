n = int(input())

count = 1
start_point = 1
end_point = 1

sum = 1
while end_point != n:
    if sum < n:
        end_point += 1
        sum += end_point
    elif sum > n:
        sum -= start_point
        start_point += 1
    else:
        count += 1
        end_point += 1
        sum += end_point

print(count)