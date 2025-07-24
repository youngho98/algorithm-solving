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
		long long lo = 0;
		long long hi = x;
		while (lo + 1 < hi) {
			long long mid = (lo + hi) / 2;
			long long new_z = ((y + mid) * 100) / (x + mid);
			if (new_z < z + 1) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
		cout << hi;
	}

	return 0;
}