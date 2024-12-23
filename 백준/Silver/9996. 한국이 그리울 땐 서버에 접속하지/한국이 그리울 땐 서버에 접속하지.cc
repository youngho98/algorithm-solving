#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;

    string pattern;
    cin >> pattern;

    string prefix, suffix;
    bool asterisk = false;

    for (char c: pattern) {
        if (c == '*') {
            asterisk = true;
        } else if (!asterisk) {
            prefix += c;
        } else {
            suffix += c;
        }
    }

    string s;
    string ans;
    for (int i = 0; i < n; i++) {
        bool check = true;
        cin >> s;

        if (s.size() < prefix.size() + suffix.size()) {
            check = false;
            goto o;
        }

        for (int j = 0; j < prefix.size(); j++) {
            if (s[j] != prefix[j]) {
                check = false;
            }
        }

        for (int j = 0; j < suffix.size(); j++) {
            if (s[s.size() - 1 - j] != suffix[suffix.size() - 1 - j]) {
                check = false;
            }
        }

        o:
        if (check) {
            ans += "DA\n";
        } else {
            ans += "NE\n";
        }
    }

    cout << ans;

    return 0;
}