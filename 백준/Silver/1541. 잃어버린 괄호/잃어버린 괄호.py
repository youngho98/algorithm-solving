# 식 입력
ipt = input()

# 숫자, 연산자 분리
nums = []
num = ""
operator = []

for i in ipt:
    if i == "+" or i == "-":
        operator.append(i)
        nums.append(num)
        num = ""
    else:
        num += i
nums.append(num)
nums = list(map(int, nums))

# (-) 부호 인덱스 찾기
try:
    idx = operator.index("-")
except:
    idx = 100

# 계산
cal = 0
for i in range(len(nums)):
    if i <= idx:
        cal += nums[i]
    else:
        cal -= nums[i]

# 출력
print(cal)