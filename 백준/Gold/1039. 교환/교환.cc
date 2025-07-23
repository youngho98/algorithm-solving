#include <iostream>
#include <string>
#include <deque>
#include <unordered_set>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string num;
	int k;
	cin >> num >> k;
	
	deque<string> dq;
	dq.push_back(num);
	int cnt = 0;
	int num_len = num.length();
	int ans = -1;

	while (!dq.empty() && cnt < k) {
		unordered_set<string> visited;
		int dq_size = dq.size();
		for (int t = 0; t < dq_size; t++) {
			string now = dq.front();
			dq.pop_front();
			for (int i = 0; i < num_len; i++) {
				for (int j = i + 1; j < num_len; j++) {
					swap(now[i], now[j]);
					if (now[0] != '0' && visited.find(now) == visited.end()) {
						if (cnt == k - 1) {
							ans = max(ans, stoi(now));
						}
						visited.insert(now);
						dq.push_back(now);
					}
					swap(now[i], now[j]);
				}
			}
		}
		cnt++;
	}

	cout << ans;
	
	return 0;
}