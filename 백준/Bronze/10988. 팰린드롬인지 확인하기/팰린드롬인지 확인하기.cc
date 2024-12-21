#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    string word;
    cin >> word;

    string originWord = word;
    reverse(word.begin(), word.end());

    if (originWord == word) {
        cout << 1;
    } else {
        cout << 0;
    }

    return 0;
}