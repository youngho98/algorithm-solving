# 숫자를 하나 불렀을 때 답이 될 수 있는 값들만 새로운 리스트에 저장하는 함수
def num_baseball(question, strike, ball, lst):
    cc = question % 10 # 질문 1의 자리
    question //= 10
    bb = question % 10 # 질문 10의 자리
    question //= 10
    aa = question # 질문 100의 자리
    new_lst = []

    for answer in lst:
        c = answer % 10 # 정답 1의 자리
        answer //= 10
        b = answer % 10 # 정답 10의 자리
        answer //= 10
        a = answer # 정답 100의 자리

        strike_count = 0
        ball_count = 0

        if b == 0 or c == 0:
            continue

        if a != b and b != c and c != a:
            # strike 확인
            if a == aa:
                strike_count += 1
            if b == bb:
                strike_count += 1
            if c == cc:
                strike_count += 1
            
            # ball 확인
            if a != aa and (a == bb or a == cc):
                ball_count += 1
            if b != bb and (b == aa or b == cc):
                ball_count += 1
            if c != cc and (c == aa or c == bb):
                ball_count += 1
            
            if strike_count == strike and ball_count == ball:
                    new_lst.append(a * 100 + b * 10 + c)
                    
    return new_lst

import sys
# 질문 횟수
n = int(sys.stdin.readline())

# 첫 번째 질문 시행
old_lst = list(range(100, 1000)) 
question, strike, ball = map(int, sys.stdin.readline().split())
new_lst = num_baseball(question, strike, ball, old_lst)

# 나머지 질문들 시행
for i in range(n - 1):
    question, strike, ball = map(int, sys.stdin.readline().split())
    new_lst = num_baseball(question, strike, ball, new_lst)

# 최종 출력
print(len(new_lst))