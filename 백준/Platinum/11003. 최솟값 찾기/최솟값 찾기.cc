#include <iostream>
#include <deque>

using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, l;
	cin >> n >> l;

	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	deque<pair<int, int>> dq; // [value, idx]
	for (int i = 0; i < n; i++) {
		if (!dq.empty() && dq.front().second < i - l + 1) {
			dq.pop_front();
		}
		while (!dq.empty() && dq.back().first > arr[i]) {
			dq.pop_back();
		}
		dq.push_back(make_pair(arr[i], i));
		cout << dq.front().first << " ";
	}

	return 0;
}