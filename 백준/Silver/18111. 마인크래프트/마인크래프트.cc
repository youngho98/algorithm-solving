#define _CRT_SECURE_NO_WARNINGS

#include <stdio.h>

int main() {
	int ground[500][500];

	int N, M, B;
	scanf("%d %d %d", &N, &M, &B);

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			scanf("%d", &ground[i][j]);
		}
	}

	int ansTime = 1e9;
	int ansHeight = -1;
	for (int i = 0; i < 257; i++) {
		int block = B;
		int time = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M; y++) {
				if (ground[x][y] < i) {
					int diff = i - ground[x][y];
					time += diff;
					block -= diff;
				}
				else if (ground[x][y] > i) {
					int diff = ground[x][y] - i;
					time += diff * 2;
					block += diff;
				}
			}
		}
		if (block >= 0 && time <= ansTime) {
			ansTime = time;
			ansHeight = i;
		}
	}

	printf("%d %d", ansTime, ansHeight);

	return 0;
}
