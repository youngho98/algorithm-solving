#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    int n, k;
    cin >> n;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    for (int i = 0; i < n; i++) {
        cin >> k;
        if (k == 0) {
            if (pq.empty()) {
                cout << 0 << "\n";
            } else {
                cout << pq.top() << "\n";
                pq.pop();
            }
        } else {
            pq.push(k);
        }
    }

    return 0;
}