#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    
    sort(score.begin(), score.end());

    for (int i = score.size() - m; i >= 0; i-= m) {
        answer += score[i];
    }
    
    answer *= m;
    
    return answer;
}