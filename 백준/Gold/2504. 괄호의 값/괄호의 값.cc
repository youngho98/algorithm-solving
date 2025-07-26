#include <iostream>
#include <deque>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    
    string s;
    cin >> s;

    int len = s.length();
    int temp = 1;
    int answer = 0;

    deque<char> dq;
    for (int i = 0; i < len; i++) {
        if (s[i] == '(') {
            temp *= 2;
            dq.push_back('(');
        } else if (s[i] == '[') {
            temp *= 3;
            dq.push_back('[');
        } else if (s[i] == ')') {
            if (dq.empty() || dq.back() == '[') {
                answer = 0;
                break;
            }
            if (s[i - 1] == '(') {
                answer += temp;
                temp /= 2;
                dq.pop_back();
            } else {
                temp /= 2;
                dq.pop_back();
            }
        } else if (s[i] == ']') {
            if (dq.empty() || dq.back() == '(') {
                answer = 0;
                break;
            }
            if (s[i - 1] == '[') {
                answer += temp;
                temp /= 3;
                dq.pop_back();
            } else {
                temp /= 3;
                dq.pop_back();
            }
        }
    }

    if (!dq.empty()) {
        answer = 0;
    }

    cout << answer;
    return 0;
}