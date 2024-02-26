import sys

grade = sys.stdin.readline().rstrip()

if grade[0] == "A":
    score = 4.0
    if grade[1] == "+":
        print(score + 0.3)
    elif grade[1] == "-":
        print(score - 0.3)
    else:
        print(score)
elif grade[0] == "B":
    score = 3.0
    if grade[1] == "+":
        print(score + 0.3)
    elif grade[1] == "-":
        print(score - 0.3)
    else:
        print(score)
elif grade[0] == "C":
    score = 2.0
    if grade[1] == "+":
        print(score + 0.3)
    elif grade[1] == "-":
        print(score - 0.3)
    else:
        print(score)
elif grade[0] == "D":
    score = 1.0
    if grade[1] == "+":
        print(score + 0.3)
    elif grade[1] == "-":
        print(score - 0.3)
    else:
        print(score)
else:
    score = 0.0
    print(score)