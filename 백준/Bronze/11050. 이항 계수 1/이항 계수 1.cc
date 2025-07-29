#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> k;

	int res = 1;
	for (int i = 0; i < k; i++) {
		res *= (n - i);
		res /= i + 1;
	}

	cout << res;

	return 0;
}