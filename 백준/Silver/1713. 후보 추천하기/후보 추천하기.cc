#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int find_num(int num);

vector<vector<int>> v; // [[학생 번호, 추천받은 횟수, 게시된 시점], ...]

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, t;

	cin >> n >> t;

	for (int i = 1; i <= t; i++) {
		int num;
		cin >> num;
		int idx = find_num(num);
		if (idx != -1) {
			v[idx][1]++;
		}
		else {
			if (v.size() >= n) {
				sort(v.begin(), v.end(), [](auto a, auto b) {
					if (a[1] == b[1]) {
						return a[2] > b[2];
					}
					return a[1] > b[1];
				});
				v.pop_back();
			}
			v.push_back(vector<int>({ num, 1, i }));
		}
	}

	sort(v.begin(), v.end(), [](auto a, auto b) {return a[0] < b[0]; });

	for (auto vv : v) {
		cout << vv[0] << " ";
	}

	return 0;
}

int find_num(int num) {
	for (int i = 0; i < v.size(); i++) {
		if (v[i][0] == num) {
			return i;
		}
	}
	return -1;
}