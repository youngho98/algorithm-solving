#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m;
	cin >> n >> m;

	vector<int> v;
	int temp;
	for (int i = 0; i < n; i++) {
		cin >> temp;
		v.push_back(temp);
	}

	sort(v.begin(), v.end());

	int ans = 0;
	int start = 0;
	int end = v[n - 1];
	
	while (start <= end) {
		long long sum = 0;
		int mid = (start + end) / 2;
		for (int i = 0; i < n; i++) {
			if (v[i] > mid) {
				sum += v[i] - mid;
			}
		}

		if (sum >= m) {
			ans = max(ans, mid);
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}

	cout << ans;

	return 0;
}