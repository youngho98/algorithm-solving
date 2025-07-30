#include <iostream>
#include <unordered_set>

using namespace std;

void choice(int cnt, int num, int check);

int n, k;
int* arr;
unordered_set<int> set;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	cin >> k;

	arr = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	choice(0, 0, 0);

	cout << set.size();

	return 0;
}

void choice(int cnt, int num, int check) {
	if (cnt == k) {
		set.insert(num);
		return;
	}
	for (int i = 0; i < n; i++) {
		if ((check & (1 << i)) == 0) {
			int new_num = num * (arr[i] < 10 ? 10 : 100) + arr[i];
			choice(cnt + 1, new_num, check + (1 << i));
		}
	}
}