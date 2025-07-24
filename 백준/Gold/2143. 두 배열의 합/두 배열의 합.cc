#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t, n, m;
	cin >> t;

	cin >> n;
	int* a = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	cin >> m;
	int* b = new int[m];
	for (int i = 0; i < m; i++) {
		cin >> b[i];
	}

	// 누적합
	int* sa = new int[n + 1];
	int* sb = new int[m + 1];
	sa[0] = 0;
	sb[0] = 0;
	for (int i = 0; i < n; i++) {
		sa[i + 1] = sa[i] + a[i];
	}
	for (int i = 0; i < m; i++) {
		sb[i + 1] = sb[i] + b[i];
	}

	// 부분 누적합
	vector<int> sum_a;
	vector<int> sum_b;

	for (int i = 0; i <= n; i++) {
		for (int j = i + 1; j <= n; j++) {
			sum_a.push_back(sa[j] - sa[i]);
		}
	}
	for (int i = 0; i <= m; i++) {
		for (int j = i + 1; j <= m; j++) {
			sum_b.push_back(sb[j] - sb[i]);
		}
	}

	sort(sum_b.begin(), sum_b.end());

	long long ans = 0;

	for (int i : sum_a) {
		int val = t - i;
		int lo = lower_bound(sum_b.begin(), sum_b.end(), val) - sum_b.begin();
		int hi = upper_bound(sum_b.begin(), sum_b.end(), val) - sum_b.begin();
		ans += hi - lo;
	}

	cout << ans;

	return 0;
}