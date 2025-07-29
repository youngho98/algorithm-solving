#include <iostream>

using namespace std;

void set_tree(long long* arr, int n);
void modify_tree(int idx, long long val);
long long find_sum(int start, int end);

long long* tree;
int start_idx;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, k;
	cin >> n >> m >> k;

	long long* arr = new long long[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	set_tree(arr, n);

	for (int i = 0; i < m + k; i++) {
		int a, b;
		long long c;
		cin >> a >> b >> c;

		if (a == 1) {
			modify_tree(b - 1, c);
		}
		else if (a == 2) {
			cout << find_sum(b - 1, (int)c - 1) << "\n";
		}
	}

	return 0;
}

void set_tree(long long* arr, int n) {
	// 세그먼트 트리의 높이
	int height = 0;
	while ((1 << height) < n) {
		height++;
	}

	// 세그먼트 트리 초기화
	tree = new long long[1 << (height + 1)];
	fill_n(tree, 1 << (height + 1), 0L);
	
	start_idx = 1 << height;

	// 초기 값 설정
	for (int i = 0; i < n; i++) {
		tree[i + start_idx] = arr[i];
	}
	for (int i = start_idx - 1; i > 0; i--) {
		tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}
}

void modify_tree(int idx, long long val) {
	idx += start_idx;

	tree[idx] = val;
	idx >>= 1;
	
	while (idx > 0) {
		tree[idx] = tree[idx << 1] + tree[(idx << 1) + 1];
		idx >>= 1;
	}
}

long long find_sum(int start, int end) {
	start += start_idx;
	end += start_idx;

	long long result = 0;
	while (start <= end) {
		if ((start & 1) == 1) {
			result += tree[start++];
		}
		if ((end & 1) == 0) {
			result += tree[end--];
		}
		start >>= 1;
		end >>= 1;
	}

	return result;
}