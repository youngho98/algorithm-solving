#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

unordered_set<string> us;

bool solution(vector<string> phone_book) {
    
    // unordered_set에 번호를 전부 집어넣기
    for (string phone : phone_book) {
        us.insert(phone);
    }
    
    // 접두사인 경우가 하나라도 있으면 false;
    for (string phone : phone_book) {
        // 길이가 1 ~ phone의 길이 - 1 까지이어야 함
        // phone.length()까지 가버리면 자신의 번호를 찾게 됨
        for (int i = 1; i < phone.length(); i++) {
            if (us.find(phone.substr(0, i)) != us.end()) {
                return false;
            }
        }
    }
    
    return true;
}