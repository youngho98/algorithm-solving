import sys

while True:
    num = sys.stdin.readline().rstrip()
    if int(num) == 0:
        break

    list = [x for x in num]
    palindrome = True
    for i in range((len(list) // 2)):
        if list[i] != list[-1 - i]:
            palindrome = False
            
    if palindrome:
        print("yes")
    else:
        print("no")