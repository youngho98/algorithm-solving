#include <iostream>
#include <string>

using namespace std;

int main() {
    string s;
    getline(cin, s);

    for (int i = 0; i < s.size(); i++) {
        if ('a' <= s[i] && s[i] <= 'z') {
            cout << (char) ((s[i] - 'a' + 13) % 26 + 'a');
        } else if ('A' <= s[i] && s[i] <= 'Z') {
            cout << (char) ((s[i] - 'A' + 13) % 26 + 'A');
        } else {
            cout << s[i];
        }
    }

    return 0;
}