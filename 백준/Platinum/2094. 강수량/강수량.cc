#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int find_rain(int idx);
void add_tree(int idx, int val);
int find_max(int start, int end);
int binary_find(int year, bool next);

int* tree;
int start_idx;
vector<int> years;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	// 트리 초기화
	int height = 0;
	while ((1 << height) < n) {
		height++;
	}
	start_idx = 1 << height;

	tree = new int[1 << (height + 1)];
	fill_n(tree, 1 << (height + 1), 0);

	// 강수량 입력
	map<int, int> map;

	for (int i = 0; i < n; i++) {
		int y, r;
		cin >> y >> r;
		map[y] = i;
		years.push_back(y);
		add_tree(i, r);
	}

	// 참, 가능, 거짓 판별
	int m;
	cin >> m;

	for (int i = 0; i < m; i++) {
		int y, x;
		cin >> y >> x;
		if (map.find(y) == map.end()) {
			if (map.find(x) == map.end()) {
				cout << "maybe";
			}
			else {
				if (find_max(binary_find(y, true), map[x] - 1) >= find_rain(map[x])) {
					cout << "false";
				}
				else {
					cout << "maybe";
				}
			}
		}
		else {
			if (map.find(x) == map.end()) {
				if (find_max(map[y] + 1, binary_find(x, false)) >= find_rain(map[y])) {
					cout << "false";
				}	
				else {
					cout << "maybe";
				}
			}
			else {
				if (find_rain(map[y]) < find_rain(map[x]) || find_max(map[y] + 1, map[x] - 1) >= find_rain(map[x])) {
					cout << "false";
				}
				else if (map[x] - map[y] == x - y) {
					cout << "true";
				}
				else {
					cout << "maybe";
				}
			}
		}
		cout << "\n";
	}

	return 0;
}

int find_rain(int idx) {
	return tree[idx + start_idx];
}

void add_tree(int idx, int val) {
	idx += start_idx;
	tree[idx] = val;
	idx >>= 1;
	while (idx > 0) {
		tree[idx] = max(tree[idx << 1], tree[(idx << 1) | 1]);
		idx >>= 1;
	}
}

int find_max(int start, int end) {
	start += start_idx;
	end += start_idx;
	int max_val = 0;
	while (start <= end) {
		if ((start & 1) == 1) {
			max_val = max(max_val, tree[start++]);
		}
		if ((end & 1) == 0) {
			max_val = max(max_val, tree[end--]);
		}
		start >>= 1;
		end >>= 1;
	}
	return max_val;
}

int binary_find(int year, bool next) {
	int lo = 0;
	int hi = years.size() - 1;
	while (lo + 1 < hi) {
		int mid = (lo + hi) / 2;
		if (years[mid] < year) {
			lo = mid;
		}
		else {
			hi = mid;
		}
	}
	if (next) {
		if (year < years[0]) {
			return 0;
		}
		return hi;
	}
	if (year > years[years.size() - 1]) {
		return years.size() - 1;
	}
	return lo;
}