#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int w, h;
	cin >> w >> h;

	int dp[101][101][2][2]; // [x, y, 우/상, 회전X/회전O]
	fill_n(dp[0][0][0], 101 * 101 * 2 * 2, 0);

	for (int i = 1; i <= w; i++) {
		dp[i][1][0][0] = 1;
	}
	for (int i = 1; i <= h; i++) {
		dp[1][i][1][0] = 1;
	}
	
	for (int i = 2; i <= w; i++) {
		for (int j = 2; j <= h; j++) {
			dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % 100000;
			dp[i][j][0][1] = dp[i - 1][j][1][0];
			dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % 100000;
			dp[i][j][1][1] = dp[i][j - 1][0][0];
		}
	}

	cout << (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % 100000;

	return 0;
}