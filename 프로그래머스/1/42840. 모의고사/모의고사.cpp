#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

// 학생 구조체 선언
struct Student {
    int num, score;
    Student(int num, int score) {
        this->num = num;
        this->score = score;
    }
};

vector<Student> students;

// 학생번호와 문제idx를 통해 그 학생이 정답을 뭘로 찍었는지 반환하는 함수
int findAns(int studentNum, int questionIdx);

vector<int> solution(vector<int> answers) {
    // 초기 학생 배열 생성
    for (int i = 0; i < 3; i++) {
        students.push_back(Student(i + 1, 0));
    }
    
    // 문제마다 정답 확인
    for (int i = 0; i < answers.size(); i++) {
        for (Student& student : students) {
            if (findAns(student.num, i) == answers[i]) student.score++;
        }
    }
    
    // 점수 내림차순, 점수가 같다면 학생번호 오름차순 정렬
    sort(students.begin(), students.end(), 
         [](Student a, Student b) {
             if (a.score == b.score) return a.num < b.num;
             return a.score > b.score;
         });
    
    // return할 answer 넣기
    vector<int> answer;
    answer.push_back(students[0].num);
    for (int i = 1; i < 3; i++) {
        if (students[i - 1].score == students[i].score) answer.push_back(students[i].num);
        else break;
    }
    
    return answer;
}

int findAns(int studentNum, int questionIdx) {
    int ans1[] = {1, 2, 3, 4, 5};
    int ans2[] = {2, 1, 2, 3, 2, 4, 2, 5};
    int ans3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    if (studentNum == 1) return ans1[questionIdx % 5];
    if (studentNum == 2) return ans2[questionIdx % 8];
    if (studentNum == 3) return ans3[questionIdx % 10];
    return 0;
}