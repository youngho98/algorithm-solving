#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif

#include <cstdio>

constexpr int LM = 1004;

int N, K, start, end;
char temp[32];
int code[LM];

int front, back, queue[LM], path[LM];
int ans[LM];

bool hammingCheck(int a, int b) {
	int x = a ^ b;
	if ((x & x - 1) == 0) return true;
	return false;
}

bool bfs() {
	front = 0, back = -1;
	queue[++back] = start;
	path[start] = -1;

	while (front <= back) {
		int now = queue[front++];
		for (int i = 1; i <= N; i++) {
			if (path[i] == 0 && hammingCheck(code[i], code[now])) {
				path[i] = now;
				if (i == end) return true;
				queue[++back] = i;
			}
		}
	}

	return false;
}

int main() {

	scanf("%d %d", &N, &K);

	for (int i = 0; i < N; i++) {
		scanf("%s", temp);
		int num = 0;
		for (int j = 0; j < K; j++) {
			num <<= 1;
			if (temp[j] == '1') num++;
		}
		code[i + 1] = num;
	}

	scanf("%d %d", &start, &end);

	if (bfs()) {
		int idx = 0;
		int node = end;
		while (node > 0) {
			ans[idx++] = node;
			node = path[node];
		}
		for (int i = idx - 1; i >= 0; i--) {
			printf("%d ", ans[i]);
		}
	}
	else {
		printf("%d", -1);
	}

	return 0;
}
