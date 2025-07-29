#include <iostream>

using namespace std;

int comb(int n, int k);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t, n, m;
	cin >> t;

	for (int i = 0; i < t; i++) {
		cin >> n >> m;
		cout << comb(m, n) << "\n";
	}

	return 0;
}

int comb(int n, int k) {
	int res = 1;
	for (int i = 0; i < k; i++) {
		res *= n - i;
		res /= i + 1;
	}
	return res;
}