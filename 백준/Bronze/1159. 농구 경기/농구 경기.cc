#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;

    int cnt[26] = {};
    string s;
    for (int i = 0; i < n; i++) {
        cin >> s;
        cnt[s[0]-'a']++;
    }

    bool play = false;
    for (int i = 0; i < 26; i++) {
        if (cnt[i] >= 5) {
            cout << (char) (i + 'a');
            play = true;
        }
    }

    if (!play) {
        cout << "PREDAJA";
    }

    return 0;
}