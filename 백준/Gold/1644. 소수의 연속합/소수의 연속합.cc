#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	// 에라토스테네스의 체
	vector<int> prime;
	bool* is_prime = new bool[n + 1];
	fill_n(is_prime, n + 1, true);
	for (int i = 2; i <= n; i++) {
		if (is_prime[i]) {
			prime.push_back(i);
			int num = i * 2;
			while (num <= n) {
				is_prime[num] = false;
				num += i;
			}
		}
	}
	reverse(prime.begin(), prime.end());

	// 투포인터 [start, end)
	int size = prime.size();
	int start = 0;
	int end = 0;
	int sum = 0;
	int cnt = 0;
	while (end < size) {
		if (sum < n) {
			sum += prime[end++];
		}
		else if (sum > n) {
			sum -= prime[start++];
		}
		else {
			cnt++;
			sum += prime[end++];
		}
	}
	while (sum >= n) {
		if (sum == n) {
			cnt++;
			break;
		}
		sum -= prime[start++];
	}

	cout << cnt;

	return 0;
}