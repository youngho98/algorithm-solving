#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> k;

	int** dp = new int*[n + 1];
	for (int i = 0; i <= n; i++) {
		dp[i] = new int[n + 1];
		fill_n(dp[i], n + 1, 1);
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
		}
	}

	cout << dp[n][k];

	return 0;
}