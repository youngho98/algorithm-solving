#include <iostream>

using namespace std;

int gcd(int a, int b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int a, b, c, d;
	cin >> a >> b >> c >> d;

	int up = a * d + b * c;
	int down = b * d;

	cout << up / gcd(up, down) << " " << down / gcd(up, down);

	return 0;
}

int gcd(int a, int b) {
	if (b == 0) {
		return a;
	}
	return gcd(b, a % b);
}