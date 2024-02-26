import sys

n = int(sys.stdin.readline())
words = []
for _ in range(n):
    words.append(sys.stdin.readline().rstrip())

alphabet = []
for i in range(27):
    alphabet.append([i, 0])

for word in words:
    for i in range(len(word) - 1, -1, -1):
        alphabet[ord(word[i]) - 64][1] += 10 ** (len(word) - 1 - i)

alphabet.sort(key = lambda x: x[1], reverse = True)

sum = 0
for i in range(10):
    sum += int(alphabet[i][1]) * (9 - i)

print(sum)