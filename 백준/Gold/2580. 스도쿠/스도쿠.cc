#include <iostream>
#include <vector>

using namespace std;

void fill(int idx, int num);
bool check(int x, int y, int num);
bool box_check(int xs, int ys, int x, int y, int num);

int sdoku[9][9];
int zero[81][2];
int zero_len = 0;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	// 스도쿠 입력
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			cin >> sdoku[i][j];
		}
	}

	// 0인 값의 좌표 입력
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			if (sdoku[i][j] == 0) {
				zero[zero_len][0] = i;
				zero[zero_len][1] = j;
				zero_len++;
			}
		}
	}

	// 숫자 채우기
	for (int i = 1; i <= 9; i++) {
		fill(0, i);
	}

	return 0;
}

void fill(int idx, int num) {
	// 다 채우면 출력
	if (idx == zero_len) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cout << sdoku[i][j] << " ";
			}
			cout << "\n";
		}
		exit(0);
	}

	// 채우기
	int x = zero[idx][0];
	int y = zero[idx][1];
	if (check(x, y, num)) {
		sdoku[x][y] = num;
	}
	else {
		return;
	}

	// 다음 공백으로
	for (int i = 1; i <= 9; i++) {
		fill(idx + 1, i);
	}
	sdoku[x][y] = 0;
}

bool check(int x, int y, int num) {
	// 가로 체크
	for (int i = 0; i < 9; i++) {
		if (i != y && sdoku[x][i] == num) {
			return false;
		}
	}

	// 세로 체크
	for (int i = 0; i < 9; i++) {
		if (i != x && sdoku[i][y] == num) {
			return false;
		}
	}

	// 박스 체크
	if (x < 3) {
		if (y < 3) {
			if (!box_check(0, 0, x, y, num)) {
				return false;
			}
		}
		else if (y < 6) {
			if (!box_check(0, 3, x, y, num)) {
				return false;
			}
		}
		else {
			if (!box_check(0, 6, x, y, num)) {
				return false;
			}
		}
	}
	else if (x < 6) {
		if (y < 3) {
			if (!box_check(3, 0, x, y, num)) {
				return false;
			}
		}
		else if (y < 6) {
			if (!box_check(3, 3, x, y, num)) {
				return false;
			}
		}
		else {
			if (!box_check(3, 6, x, y, num)) {
				return false;
			}
		}
	}
	else {
		if (y < 3) {
			if (!box_check(6, 0, x, y, num)) {
				return false;
			}
		}
		else if (y < 6) {
			if (!box_check(6, 3, x, y, num)) {
				return false;
			}
		}
		else {
			if (!box_check(6, 6, x, y, num)) {
				return false;
			}
		}
	}

	return true;
}

bool box_check(int xs, int ys, int x, int y, int num) {
	for (int i = xs; i < xs + 3; i++) {
		for (int j = ys; j < ys + 3; j++) {
			if (x == i && y == j) {
				continue;
			}
			if (sdoku[i][j] == num) {
				return false;
			}
		}
	}
	return true;
}