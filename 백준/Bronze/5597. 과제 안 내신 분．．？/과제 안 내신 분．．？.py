import sys

student_list = []

for i in range(1, 31):
    student_list.append(i)

for i in range(28):
    student_list.remove(int(sys.stdin.readline()))

print(student_list[0])
print(student_list[1])