#define _CRT_SECURE_NO_WARNINGS

#include <cstdio>

int board[19][19];

bool check(int y, int x, int dir, int num);

int main() {
	for (int i = 0; i < 19; i++) {
		for (int j = 0; j < 19; j++) {
			scanf("%d", &board[i][j]);
		}
	}

	for (int i = 0; i < 19; i++) {
		for (int j = 0; j < 19; j++) {
			int num = board[i][j];
			if (num == 0) continue;
			for (int d = 0; d < 4; d++) {
				if (check(i, j, d, num)) {
					printf("%d\n%d %d", num, i + 1, j + 1);
					return 0;
				}
			}
		}
	}

	printf("%d", 0);
	return 0;
}

bool check(int y, int x, int dir, int num) {
	// 가로 방향
	if (dir == 0) {
		if (x - 1 >= 0 && board[y][x - 1] == num) return false;
		for (int i = 1; i < 5; i++) {
			if (x + i >= 19) return false;
			if (board[y][x + i] != num) return false;
		}
		if (x + 5 < 19 && board[y][x + 5] == num) return false;
		return true;
	}
	// 세로 방향
	if (dir == 1) {
		if (y - 1 >= 0 && board[y - 1][x] == num) return false;
		for (int i = 1; i < 5; i++) {
			if (y + i >= 19) return false;
			if (board[y + i][x] != num) return false;
		}
		if (y + 5 < 19 && board[y + 5][x] == num) return false;
		return true;
	}
	// 우하 대각선
	if (dir == 2) {
		if (x - 1 >= 0 && y - 1 >= 0 && board[y - 1][x - 1] == num) return false;
		for (int i = 1; i < 5; i++) {
			if (x + i >= 19 || y + i >= 19) return false;
			if (board[y + i][x + i] != num) return false;
		}
		if (x + 5 < 19 && y + 5 < 19 && board[y + 5][x + 5] == num) return false;
		return true;
	}
	// 우상 대각선
	if (dir == 3) {
		if (x - 1 >= 0 && y + 1 < 19 && board[y + 1][x - 1] == num) return false;
		for (int i = 1; i < 5; i++) {
			if (x + i >= 19 || y - i < 0) return false;
			if (board[y - i][x + i] != num) return false;
		}
		if (x + 5 < 19 && y - 5 >= 0 && board[y - 5][x + 5] == num) return false;
		return true;
	}
	return false;
}
