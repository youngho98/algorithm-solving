#include <iostream>

using namespace std;

int find(int rank);
void add_tree(int idx, int val);
int sum_tree(int start, int end);

int tree[1 << 21];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	fill_n(tree, 1 << 21, 0);

	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a, b, c;
		cin >> a;
		if (a == 1) {
			cin >> b;
			int idx = find(b);
			add_tree(idx, -1);
			cout << idx << "\n";
		}
		else {
			cin >> b >> c;
			add_tree(b, c);
		}
	}

	return 0;
}

int find(int rank) {
	int lo = 0;
	int hi = 1000000;
	while (lo + 1 < hi) {
		int mid = (lo + hi) / 2;
		if (sum_tree(1, mid) < rank) {
			lo = mid;
		}
		else {
			hi = mid;
		}
	}
	return hi;
}

void add_tree(int idx, int val) {
	idx += 1 << 20;
	tree[idx] += val;
	idx >>= 1;
	while (idx > 0) {
		tree[idx] = tree[idx << 1] + tree[(idx << 1) | 1];
		idx >>= 1;
	}
}

int sum_tree(int start, int end) {
	int res = 0;
	start += 1 << 20;
	end += 1 << 20;
	while (start <= end) {
		if ((start & 1) == 1) {
			res += tree[start++];
		}
		if ((end & 1) == 0) {
			res += tree[end--];
		}
		start >>= 1;
		end >>= 1;
	}
	return res;
}