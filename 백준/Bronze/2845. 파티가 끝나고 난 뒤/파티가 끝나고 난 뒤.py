a, b = map(int, input().split())
print(*map(lambda x: x - a * b, list(map(int, input().split()))))