lst = []
for i in range(1, 45):
    for j in range(i):
        lst.append(i)
for i in range(10):
    lst.append(45)

a, b = map(int, input().split())

sum = 0
for i in range(a - 1, b):
    sum += lst[i]

print(sum)