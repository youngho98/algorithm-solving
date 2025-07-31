#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int arr[1010][1010];
	int dp[1010][1010];
	fill_n(arr[0], 1010 * 1010, 0);
	fill_n(dp[0], 1010 * 1010, 0);

	int h, w, n;
	cin >> h >> w >> n;

	for (int i = 1; i <= h; i++) {
		for (int j = 1; j <= w; j++) {
			cin >> arr[i][j];
		}
	}

	// n - 1번 산책시 방문횟수
	dp[1][1] = n - 1;
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j <= w; j++) {
			if (arr[i][j] == 0) {
				dp[i + 1][j] += (dp[i][j] & 1) == 1 ? dp[i][j] / 2 + 1 : dp[i][j] / 2;
				dp[i][j + 1] += dp[i][j] / 2;
			}
			else {
				dp[i + 1][j] += dp[i][j] / 2;
				dp[i][j + 1] += (dp[i][j] & 1) == 1 ? dp[i][j] / 2 + 1 : dp[i][j] / 2;
			}
		}
	}

	// n - 1 산책 후의 arr 상태
	for (int i = 1; i <= h; i++) {
		for (int j = 1; j <= w; j++) {
			if ((dp[i][j] & 1) == 1) {
				arr[i][j] = (arr[i][j] == 0) ? 1 : 0;
			}
		}
	}

	// n번째 산책
	int x = 1;
	int y = 1;
	while (x <= h && y <= w) {
		if (arr[x][y] == 0) {
			x++;
		}
		else {
			y++;
		}
	}

	cout << x << " " << y;

	return 0;
}