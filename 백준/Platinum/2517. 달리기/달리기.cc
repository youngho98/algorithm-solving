#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Player {
	int idx;
	int skill;
	Player(int idx, int skill) {
		this->idx = idx;
		this->skill = skill;
	}
};

int find_sum(int idx);
void update_tree(int idx);

int n;
int* tree;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	// 플레이어 좌표압축
	vector<Player> players;

	for (int i = 0; i < n; i++) {
		int s;
		cin >> s;
		players.push_back(Player(i, s));
	}

	sort(players.begin(), players.end(), [](auto o1, auto o2) {return o1.skill < o2.skill; });

	for (int i = 0; i < n; i++) {
		players[i].skill = i + 1;
	}

	sort(players.begin(), players.end(), [](auto o1, auto o2) {return o1.idx < o2.idx; });

	// 펜윅 트리
	tree = new int[n + 1];
	fill_n(tree, n + 1, 0);

	for (int i = 0; i < n; i++) {
		int skill = players[i].skill;
		cout << i + 1 - find_sum(skill) << "\n";
		update_tree(skill);
	}

	return 0;
}

int find_sum(int idx) {
	int sum = 0;
	while (idx > 0) {
		sum += tree[idx];
		idx -= (idx & -idx);
	}
	return sum;
}

void update_tree(int idx) {
	while (idx <= n) {
		tree[idx]++;
		idx += (idx & -idx);
	}
}