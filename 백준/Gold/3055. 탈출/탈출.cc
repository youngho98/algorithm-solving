#include <iostream>
#include <deque>

using namespace std;

struct Point {
	int x;
	int y;
};

int bfs();
bool in_map(int x, int y);

deque<Point> water, dq;
char** map;
bool** visited;
int r, c;

int main() {
	cin >> r >> c;

	map = new char*[r];
	visited = new bool*[r];
	for (int i = 0; i < r; i++) {
		map[i] = new char[c];
		visited[i] = new bool[c];
		cin >> map[i];
		fill_n(visited[i], c, false);
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (map[i][j] == '*') {
				Point temp;
				temp.x = i;
				temp.y = j;
				water.push_back(temp);
			} else if (map[i][j] == 'S') {
				map[i][j] = '.';
				visited[i][j] = true;
				Point temp;
				temp.x = i;
				temp.y = j;
				dq.push_back(temp);
			}
		}
	}

	int ans = bfs();
	if (ans == 0) {
		cout << "KAKTUS";
	} else {
		cout << ans;
	}

	return 0;
}

int bfs() {
	int dx[] = { -1, 0, 1, 0 };
	int dy[] = { 0, 1, 0, -1 };

	int cnt = 1;

	while (!dq.empty()) {
		int dq_size = dq.size();
		int water_size = water.size();

		for (int i = 0; i < water_size; i++) {
			Point w = water.front();
			water.pop_front();

			for (int j = 0; j < 4; j++) {
				int nwx = w.x + dx[j];
				int nwy = w.y + dy[j];
				if (in_map(nwx, nwy) && map[nwx][nwy] == '.') {
					map[nwx][nwy] = '*';
					Point temp;
					temp.x = nwx;
					temp.y = nwy;
					water.push_back(temp);
				}
			}
		}

		for (int i = 0; i < dq_size; i++) {
			Point now = dq.front();
			dq.pop_front();

			for (int j = 0; j < 4; j++) {
				int nx = now.x + dx[j];
				int ny = now.y + dy[j];
				if (in_map(nx, ny) && map[nx][ny] == 'D') {
					return cnt;
				}
				if (in_map(nx, ny) && map[nx][ny] == '.' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					Point temp;
					temp.x = nx;
					temp.y = ny;
					dq.push_back(temp);
				}
			}
		}

		cnt++;
	}

	return 0;
}

bool in_map(int x, int y) {
	return 0 <= x && x < r && 0 <= y && y < c;
}