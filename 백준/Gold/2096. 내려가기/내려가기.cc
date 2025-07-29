#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	int score[3];
	int dp_max[2][3];
	int dp_min[2][3];

	fill_n(dp_max[0], 3, 0);
	fill_n(dp_min[0], 3, 0);

	for (int i = 0; i < n; i++) {
		cin >> score[0] >> score[1] >> score[2];

		dp_max[1][0] = max(dp_max[0][0], dp_max[0][1]) + score[0];
		dp_max[1][1] = max(max(dp_max[0][0], dp_max[0][1]), dp_max[0][2]) + score[1];
		dp_max[1][2] = max(dp_max[0][1], dp_max[0][2]) + score[2];

		dp_min[1][0] = min(dp_min[0][0], dp_min[0][1]) + score[0];
		dp_min[1][1] = min(min(dp_min[0][0], dp_min[0][1]), dp_min[0][2]) + score[1];
		dp_min[1][2] = min(dp_min[0][1], dp_min[0][2]) + score[2];

		for (int j = 0; j < 3; j++) {
			dp_max[0][j] = dp_max[1][j];
			dp_min[0][j] = dp_min[1][j];
		}
	}

	cout << max(max(dp_max[1][0], dp_max[1][1]), dp_max[1][2]) << " ";
	cout << min(min(dp_min[1][0], dp_min[1][1]), dp_min[1][2]);

	return 0;
}