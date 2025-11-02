#include <stdio.h>
#include <deque>

using namespace std;

int N, M;
int map[300][300];
bool visited[300][300];

struct Point {
    int y, x;
    Point(int y, int x) {
        this->y = y;
        this->x = x;
    }
};

bool bfs();

int main() {

    // 입력
    scanf("%d %d", &N, &M);
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &map[i][j]);
        }
    }

    if (bfs()) printf("Yes");
    else printf("No");

    return 0;
}

bool bfs() {
    if (M == 1 && N == 1) return true;

    int dy[] = {1, 0};
    int dx[] = {0, 1};

    deque<Point> dq;
    dq.push_back(Point(0, 0));
    visited[0][0] = true;

    while (!dq.empty()) {
        Point now = dq.front();
        dq.pop_front();
        for (int i = 0; i < 2; i++) {
            int ny = now.y + dy[i];
            int nx = now.x + dx[i];
            if (ny == M - 1 && nx == N - 1) return true;
            if (!visited[ny][nx] && map[ny][nx] == 1) {
                visited[ny][nx] = true;
                dq.push_back(Point(ny, nx));
            }
        }
    }
    return false;
}