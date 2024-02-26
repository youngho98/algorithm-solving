import sys

word = sys.stdin.readline().rstrip()

lst = [0 for i in range(26)]

for letter in word:
    for i in range(26):
        if ord(letter.upper()) == 65 + i:
            lst[i] += 1

idx = lst.index(max(lst))

same = False
for i in range(idx + 1, 26):
    if lst[idx] == lst[i]:
        same = True
        break

if not same:
    print(chr(idx + 65))
else:
    print("?")