#include <iostream>
#include <algorithm>

using namespace std;

int dfs(int x, int y);
 
int n, m;
char** board;	
int** dp;
bool** visited;
int dx[] = { -1, 0, 1, 0 };
int dy[] = { 0, 1, 0, -1 };

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	board = new char*[n];
	dp = new int*[n];
	visited = new bool*[n];
	for (int i = 0; i < n; i++) {
		board[i] = new char[m];
		dp[i] = new int[m];
		visited[i] = new bool[m];
		cin >> board[i];
		fill_n(dp[i], m, -1);
		fill_n(visited[i], m, false);
	}

	cout << dfs(0, 0) << "\n";

	return 0;
}

int dfs(int x, int y) {
	if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] == 'H') {
		return 0;
	}

	if (visited[x][y]) {
		cout << -1;
		exit(0);
	}

	if (dp[x][y] != -1) {
		return dp[x][y];
	}

	visited[x][y] = true;
	dp[x][y] = 0;

	int dist = board[x][y] - '0';
	for (int i = 0; i < 4; i++) {
		int nx = x + dx[i] * dist;
		int ny = y + dy[i] * dist;
		dp[x][y] = max(dp[x][y], dfs(nx, ny) + 1);
	}

	visited[x][y] = false;
	
	return dp[x][y];
}