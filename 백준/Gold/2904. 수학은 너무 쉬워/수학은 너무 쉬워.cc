#include <iostream>
#include <vector>

using namespace std;

void prime_find();
void prime_fac(int num);
void find_gcd_prime(int num);
int find_cnt(int num);
int power(int base, int exp);

int prime[1000001];
int gcd_prime[1000001];
vector<int> primes;

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

	fill_n(prime, 1000001, 0);
	fill_n(gcd_prime, 1000001, 0);

	// 소수판별
	prime_find();

	// 소인수분해
	for (int i = 0; i < n; i++) {
		prime_fac(arr[i]);
	}

	// 최대공약수 찾기
	int gcd = 1;
	for (int i : primes) {
		if (prime[i] >= n) {
			gcd *= power(i, (prime[i] / n));
		}
	}

	// 최대공약수 소인수분해
	find_gcd_prime(gcd);

	// 이동횟수 구하기
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		cnt += find_cnt(arr[i]);
	}

	cout << gcd << " " << cnt;

	return 0;
}

void prime_find() {
	for (int i = 2; i <= 1000; i++) {
		if (prime[i] == 0) {
			for (int j = 2 * i; j <= 1000000; j += i) {
				prime[j] = -1;
			}
		}
	}
	for (int i = 2; i <= 1000000; i++) {
		if (prime[i] == 0) {
			primes.push_back(i);
		}
	}
}

void prime_fac(int num) {
	for (int i : primes) {
		while (num > 1 && num % i == 0) {
			prime[i]++;
			num /= i;
		}
	}
}

void find_gcd_prime(int num) {
	for (int i : primes) {
		while (num > 1 && num % i == 0) {
			gcd_prime[i]++;
			num /= i;
		}
	}
}

int find_cnt(int num) {
	int cnt = 0;
	for (int i : primes) {
		for (int j = 0; j < gcd_prime[i]; j++) {
			if (num % i == 0) {
				num /= i;
			}
			else {
				cnt++;
			}
		}
	}
	return cnt;
}

int power(int base, int exp) {
	if (exp == 0) {
		return 1;
	}
	if ((exp & 1) == 0) {
		return power(base * base, exp >> 1);
	}
	else {
		return base * power(base, exp - 1);
	}
}