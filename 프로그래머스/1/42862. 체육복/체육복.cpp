#include <vector>

using namespace std;

// idx번 학생이 가진 체육복의 갯수
// 최대 30명까지 존재할 수 있고, 좌우에서 빌리는 로직에서 NPE가 발생하지 않도록 32개로 넉넉하게 잡는다.
int clothes[32];

int solution(int n, vector<int> lost, vector<int> reserve) {
    
    // 전부 1개씩 가지고 시작
    for (int i = 1; i <= n; i++) {
        clothes[i] = 1;
    }
    
    // 도난 당한 학생
    for (int i : lost) {
        clothes[i]--;
    }
    
    // 여벌옷 가져온 학생
    for (int i : reserve) {
        clothes[i]++;
    }
    
    // 체육복이 없는 친구는 왼쪽 친구한테 먼저 빌리고, 왼쪽이 없으면 오른쪽 친구한테 빌린다.
    // students[0]과 students[n + 1]은 실제로 존재하지 않지만 어차피 2가 아니므로 못빌린다.
    for (int i = 1; i <= n; i++) {
        if (clothes[i] == 0) {
            if (clothes[i - 1] == 2) {
                clothes[i]++;
                clothes[i - 1]--;
            } else if (clothes[i + 1] == 2) {
                clothes[i]++;
                clothes[i + 1]--;
            }
        }
    }
    
    // 최종적으로 체육복이 있는 학생 찾기
    int answer = 0;
    for (int i = 1; i <= n; i++) {
        if (clothes[i] >= 1) {
            answer++;
        }
    }
    return answer;
}