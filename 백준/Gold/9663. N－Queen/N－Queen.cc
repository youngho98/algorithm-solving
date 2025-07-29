#include <iostream>

using namespace std;

void queen(int x);
bool check(int x);

int n, cnt;
int* board;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	board = new int[n];
	queen(0);
	cout << cnt;
}

void queen(int x) {
	if (x == n) {
		cnt++;
		return;
	}
	for (int i = 0; i < n; i++) {
		board[x] = i;
		if (check(x)) {
			queen(x + 1);
		}
	}
}

bool check(int x) {
	for (int i = 0; i < x; i++) {
		if (board[x] == board[i] || abs(x - i) == abs(board[x] - board[i])) {
			return false;
		}
	}
	return true;
}