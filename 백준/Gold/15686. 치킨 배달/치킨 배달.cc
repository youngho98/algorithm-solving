#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void recur(int dept, int idx, int check);
int dist(int a, int b);

int m;
int answer = 10000;
vector<int> house, chicken;
int house_size, chicken_size;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, k;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> k;
			if (k == 1) {
				house.push_back(100 * i + j);
			} else if (k == 2) {
				chicken.push_back(100 * i + j);
			}
		}
	}

	house_size = house.size();
	chicken_size = chicken.size();

	recur(0, 0, 0);

	cout << answer;

	return 0;
}

void recur(int dept, int idx, int check) {
	if (dept == m) {
		int city_dist = 0;
		for (int i = 0; i < house_size; i++) {
			int chicken_dist = 100;
			for (int j = 0; j < chicken_size; j++) {
				if ((check & (1 << j)) != 0) {
					chicken_dist = min(chicken_dist, dist(house[i], chicken[j]));
				}
			}
			city_dist += chicken_dist;
		}
		answer = min(answer, city_dist);
		return;
	}
	for (int i = idx; i < chicken_size; i++) {
		recur(dept + 1, i + 1, check + (1 << i));
	}
}

int dist(int a, int b) {
	int ax = a / 100;
	int ay = a % 100;
	int bx = b / 100;
	int by = b % 100;
	return abs(ax - bx) + abs(ay - by);
}