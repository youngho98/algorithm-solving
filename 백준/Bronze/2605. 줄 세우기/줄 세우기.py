n = int(input())
num = list(map(int, input().split()))
list = []
order = 1;
for i in num:
    list.insert(len(list) - i, order)
    order += 1
print(*list)