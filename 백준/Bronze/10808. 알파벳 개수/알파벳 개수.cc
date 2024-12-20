#include <iostream>

using namespace std;

int main() {
    string s;
    cin >> s;

    int cnt[26] = {};
    for (int i = 0; i < s.size(); i++) {
        cnt[s[i] - 'a']++;
    }

    for (int i : cnt) {
        cout << i << " ";
    }
}