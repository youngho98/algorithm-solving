#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	int* a = new int[n];
	int* b = new int[n];
	int* c = new int[n];
	int* d = new int[n];

	for (int i = 0; i < n; i++) {
		cin >> a[i] >> b[i] >> c[i] >> d[i];
	}

	vector<int> va;
	vector<int> vb;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			va.push_back(a[i] + b[j]);
			vb.push_back(c[i] + d[j]);
		}
	}

	sort(va.begin(), va.end());
	sort(vb.begin(), vb.end());

	long long cnt = 0;
	int idx_a = 0;
	int idx_b = n * n - 1;
	while (idx_a < n * n && idx_b >= 0) {
		int sum = va[idx_a] + vb[idx_b];
		if (sum < 0) {
			idx_a++;
		}
		else if (sum > 0) {
			idx_b--;
		}
		else {
			long long cnt_a = 1;
			long long cnt_b = 1;
			while (idx_a + 1 < n * n && va[idx_a] == va[idx_a + 1]) {
				idx_a++;
				cnt_a++;
			}
			while (idx_b - 1 >= 0 && vb[idx_b] == vb[idx_b - 1]) {
				idx_b--;
				cnt_b++;
			}
			cnt += cnt_a * cnt_b;
			idx_a++;
		}
	}

	cout << cnt;

	return 0;
}