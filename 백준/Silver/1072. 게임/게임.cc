#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long x, y;
	cin >> x >> y;
	long long z = (y * 100) / x;

	if (z >= 99) {
		cout << -1;
	} else {
		long long start = 0;
		long long end = x;
		while (start < end) {
			long long mid = (start + end) / 2;
			long long new_z = ((y + mid) * 100) / (x + mid);
			if (new_z < z + 1) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		cout << start;
	}

	return 0;
}