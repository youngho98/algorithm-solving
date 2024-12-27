#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    map<string, int> alphaDict;
    string numDict[n + 1];

    for (int i = 1; i <= n; i++) {
        string name;
        cin >> name;
        alphaDict.insert({name, i});
        numDict[i] = name;
    }

    string ans;
    for (int i = 0; i < m; i++) {
        string q;
        cin >> q;
        if ('A' <= q[0] && q[0] <= 'Z') {
            ans += to_string(alphaDict[q]);
            ans += "\n";
        } else {
            ans += numDict[stoi(q)];
            ans += "\n";
        }
    }

    cout << ans;

    return 0;
}