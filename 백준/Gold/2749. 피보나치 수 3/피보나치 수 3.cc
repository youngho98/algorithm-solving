#include <iostream>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	long long n;
	cin >> n;

	int fibo[1500000];
	fibo[0] = 0;
	fibo[1] = 1;
	for (int i = 2; i < 1500000; i++) {
		fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
	}

	cout << fibo[n % 1500000];

	return 0;
}