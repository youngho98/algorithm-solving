#include<string>
#include<deque>

using namespace std;

bool solution(string s) {
    
    deque<char> dq;
    
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(') dq.push_back('(');
        else if (!dq.empty()) dq.pop_back();
        else return false;
    }

    return dq.empty();
}