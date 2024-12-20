#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    string sa, sb, sc;
    int cost[4] = {};

    cin >> sa;
    cin >> sb;
    cin >> sc;
    cost[1] = stoi(sa);
    cost[2] = stoi(sb);
    cost[3] = stoi(sc);

    int cnt[100] = {};
    string ss, se;
    for (int i = 0; i < 3; i++) {
        cin >> ss;
        cin >> se;
        int s = stoi(ss);
        int e = stoi(se);
        for (int j = s; j < e; j++) {
            cnt[j]++;
        }
    }

    int ans = 0;
    for (int i : cnt) {
        ans += cost[i] * i;
    }

    cout << ans;

    return 0;
}