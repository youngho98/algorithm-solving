#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 입력
	int n, m, k;
	cin >> n >> m >> k;

	// n, m의 개수에 따른 조합의 수 dp 배열
	int** dp = new int*[n + 1];
	for (int i = 0; i <= n; i++) {
		dp[i] = new int[m + 1];
		fill_n(dp[i], m + 1, 1);
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			dp[i][j] = min(dp[i - 1][j] + dp[i][j - 1], 1000000001);
		}
	}

	// k가 큰값이면 -1
	if (dp[n][m] < k) {
		cout << -1;
		return 0;
	}

	// k번재 숫자 탐색
	while (n > 0 || m > 0) {
		if (n == 0) {
			cout << 'z';
			m--;
		}
		else if (m == 0) {
			cout << 'a';
			n--;
		}
		else if (dp[n - 1][m] >= k) {
			cout << 'a';
			n--;
		}
		else {
			k -= dp[n - 1][m];
			cout << 'z';
			m--;
		}
	}

	return 0;
}
