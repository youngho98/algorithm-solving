n = int(input())

print(" " * (n - 1), end = "")
print("*")
for i in range(1, n):
    print(" " * (n - i - 1), end = "")
    print("*", end = "")
    print(" " * (i * 2 - 1), end = "")
    print("*")