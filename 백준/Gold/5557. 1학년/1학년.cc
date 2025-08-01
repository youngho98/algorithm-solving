#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int arr[100];
	long long dp[100][21];

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	fill_n(dp[0], 100 * 21, 0);

	dp[0][arr[0]] = 1;
	for (int i = 0; i < n - 1; i++) {
		for (int j = 0; j <= 20; j++) {
			if (0 <= j + arr[i + 1] && j + arr[i + 1] <= 20) {
				dp[i + 1][j + arr[i + 1]] += dp[i][j];
			}
			if (0 <= j - arr[i + 1] && j - arr[i + 1] <= 20) {
				dp[i + 1][j - arr[i + 1]] += dp[i][j];
			}
		}
	}

	cout << dp[n - 2][arr[n - 1]];

	return 0;
}