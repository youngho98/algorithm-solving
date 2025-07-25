#include <iostream>
#include <set>
#include <vector>
#include <algorithm>
#include <deque>

using namespace std;

struct Point {
	int x;
	int y;
	Point() {}
	Point(int x, int y) {
		this->x = x;
		this->y = y;
	}
};

Point find_post();
int find_house();
bool bfs(int low, int high);
bool in_map(int x, int y);
bool in_height(int nx, int ny, int low, int high);

int n, house;
Point post;
char** map;
int** hmap;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	
	// map 입력 & 우체국 위치 저장
	map = new char*[n];
	for (int i = 0; i < n; i++) {
		map[i] = new char[n];
		cin >> map[i];
	}

	post = find_post();
	house = find_house();

	// 고도 입력
	set<int> h;
	hmap = new int*[n];
	for (int i = 0; i < n; i++) {
		hmap[i] = new int[n];
		for (int j = 0; j < n; j++) {
			cin >> hmap[i][j];
			h.insert(hmap[i][j]);
		}
	}

	vector<int> height;
	for (int hh : h) {
		height.push_back(hh);
	}
	sort(height.begin(), height.end());

	// 투포인터 & bfs
	int start = 0;
	int end = 0;
	int answer = 1000000;
	while (end < height.size() - 1) {
		if (bfs(height[start], height[end])) {
			answer = min(answer, height[end] - height[start]);
			start++;
		}
		else {
			end++;
		}
	}
	while (start < height.size() && bfs(height[start], height[end])) {
		answer = min(answer, height[end] - height[start]);
		start++;
	}

	cout << answer;

	return 0;
}

Point find_post() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 'P') {
				return Point(i, j);
			}
		}
	}
	return Point(-1, -1);
}

int find_house() {
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j] == 'K') {
				cnt++;
			}
		}
	}
	return cnt;
}

bool bfs(int low, int high) {
	if (hmap[post.x][post.y] < low || hmap[post.x][post.y] > high) {
		return false;
	}

	int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	
	bool** visited = new bool*[n];
	for (int i = 0; i < n; i++) {
		visited[i] = new bool[n];
		fill_n(visited[i], n, false);
	}

	deque<Point> dq;
	dq.push_back(post);
	visited[post.x][post.y] = true;

	int cnt = 0;
	while (!dq.empty()) {
		Point now = dq.front();
		dq.pop_front();

		for (int i = 0; i < 8; i++) {
			int nx = now.x + dx[i];
			int ny = now.y + dy[i];
			if (in_map(nx, ny) && in_height(nx, ny, low, high) && !visited[nx][ny]) {
				if (map[nx][ny] == 'K') {
					cnt++;
					if (cnt == house) {
						return true;
					}
				}
				visited[nx][ny] = true;
				dq.push_back(Point(nx, ny));
			}
		}
	}

	return false;
}

bool in_map(int x, int y) {
	return 0 <= x && x < n && 0 <= y && y < n;
}

bool in_height(int nx, int ny, int low, int high) {
	return low <= hmap[nx][ny] && hmap[nx][ny] <= high;
}