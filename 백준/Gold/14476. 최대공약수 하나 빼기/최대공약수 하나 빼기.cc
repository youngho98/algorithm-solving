#include <iostream>

using namespace std;

int gcd(int a, int b);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	int* lgcd = new int[n];
	lgcd[0] = arr[0];
	for (int i = 0; i < n; i++) {
		lgcd[i] = gcd(lgcd[i - 1], arr[i]);
	}

	int* rgcd = new int[n];
	rgcd[n - 1] = arr[n - 1];
	for (int i = n - 2; i >= 0; i--) {
		rgcd[i] = gcd(rgcd[i + 1], arr[i]);
	}

	int max_gcd = rgcd[1];
	int k = arr[0];
	if (lgcd[n - 2] > max_gcd) {
		max_gcd = lgcd[n - 2];
		k = arr[n - 1];
	}
	for (int i = 1; i < n - 1; i++) {
		int temp = gcd(lgcd[i - 1], rgcd[i + 1]);
		if (temp > max_gcd) {
			max_gcd = temp;
			k = arr[i];
		}
	}

	if (k % max_gcd == 0) {
		cout << -1;
	}
	else {
		cout << max_gcd << " " << k;
	}

	return 0;
}

int gcd(int a, int b) {
	return b ? gcd(b, a % b) : a;
}