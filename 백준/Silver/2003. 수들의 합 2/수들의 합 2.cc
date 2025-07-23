#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, num;
	cin >> n >> m;

	int* prefix_sum = new int[n + 1];

	prefix_sum[0] = 0;
	for (int i = 0; i < n; i++) {
		cin >> num;
		prefix_sum[i + 1] = prefix_sum[i] + num;
	}

	int start = 0;
	int end = 0;
	int cnt = 0;

	while (end < n) {
		if (prefix_sum[end] - prefix_sum[start] < m) {
			end++;
		} else {
			if (prefix_sum[end] - prefix_sum[start] == m) {
				cnt++;
			}
			start++;
		}
	}

	while (true) {
		if (prefix_sum[end] - prefix_sum[start] > m) {
			start++;
		} else {
			if (prefix_sum[end] - prefix_sum[start] == m) {
				cnt++;
			}
			break;
		}
	}

	cout << cnt;

	return 0;
}