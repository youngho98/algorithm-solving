import sys

weight = int(sys.stdin.readline())
sqrt = weight ** 0.5
jewel = 2

jewels = []
while jewel < sqrt:
    if weight % jewel == 0:
        while weight % jewel == 0:
            jewels.append(jewel)
            weight //= jewel
    else:
        jewel += 1

if weight != 1:
    jewels.append(weight)
    
print(len(jewels))
print(*jewels)