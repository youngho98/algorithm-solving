#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    
    // unordered_map 선언
    unordered_map<string, int> um;
    
    // 참가자 등록
    for (string s : participant) {
        if (um.find(s) == um.end()) {
            um[s] = 1;
        } else {
            um[s]++;
        }
    }
    
    // 완주자 삭제
    for (string s : completion) {
        if (--um[s] == 0) {
            um.erase(s);
        }
    }
    
    // 정답 return
    return um.begin()->first;
}