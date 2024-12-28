#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    string s;
    cin >> s;

    // 알파벳 개수를 저장
    int alphabet[26] = {};
    for (int i = 0; i < s.size(); i++) {
        alphabet[s[i] - 'A']++;
    }

    // 홀수인 알파벳 체크
    int check = -1;
    int cnt = 0;
    for (int i = 0; i < 26; i++) {
        if ((alphabet[i] & 1) == 1) {
            check = i;
            cnt++;
        }
    }

    string ans;
    if ((s.size() & 1) == 1) {
        if (cnt == 0) {
            for (int i = 0; i < 26; i++) {
                while (alphabet[i] > 0) {
                    ans += (char)(i + 'A');
                    alphabet[i] -= 2;
                }
            }
            string rev = ans;
            reverse(rev.begin(), rev.end());
            ans += rev;
        } else if (cnt == 1) {
            for (int i = 0; i < 26; i++) {
                while (alphabet[i] > 1) {
                    ans += (char)(i + 'A');
                    alphabet[i] -= 2;
                }
            }
            string rev = ans;
            reverse(rev.begin(), rev.end());
            ans += (char)(check + 'A');
            ans += rev;
        } else {
            ans = "I'm Sorry Hansoo";
        }
    } else {
        if (cnt == 0) {
            for (int i = 0; i < 26; i++) {
                while (alphabet[i] > 0) {
                    ans += (char)(i + 'A');
                    alphabet[i] -= 2;
                }
            }
            string rev = ans;
            reverse(rev.begin(), rev.end());
            ans += rev;
        } else {
            ans = "I'm Sorry Hansoo";
        }
    }

    cout << ans;

    return 0;
}