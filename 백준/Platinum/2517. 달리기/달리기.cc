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

int check(int skill);
void update_tree(int idx);
int find_sum(int start, int end);

int n, tree_depth;
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
		players[i].skill = i;
	}

	sort(players.begin(), players.end(), [](auto o1, auto o2) {return o1.idx < o2.idx; });

	// 세그먼트 트리
	tree_depth = 0;
	while (true) {
		if ((1 << tree_depth) >= n) {
			break;
		}
		tree_depth++;
	}

	tree = new int[1 << (tree_depth + 1)];
	fill_n(tree, 1 << (tree_depth + 1), 0);

	for (int i = 0; i < n; i++) {
		cout << check(players[i].skill) << "\n";
	}

	return 0;
}

int check(int skill) {
	update_tree(skill);
	return find_sum(skill, n - 1);
}

void update_tree(int idx) {
	idx += 1 << tree_depth;
	while (idx > 0) {
		tree[idx]++;
		idx >>= 1;
	}
}

int find_sum(int start, int end) {
	start += 1 << tree_depth;
	end += 1 << tree_depth;
	int sum = 0;
	while (start <= end) {
		if ((start & 1) == 1) {
			sum += tree[start];
			start++;
		}
		if ((end & 1) == 0) {
			sum += tree[end];
			end--;
		}
		start >>= 1;
		end >>= 1;
	}
	return sum;
}