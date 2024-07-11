import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][][] visited;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[n][m][2];

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Deque<Point> deque = new ArrayDeque<>();

        visited[0][0][0] = true;
        deque.addLast(new Point(x, y, 1, 0));

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                // 맵 밖이면 continue
                if (!inMap(nx, ny)) {
                    continue;
                }
                // 벽이 아닐 때
                if (map[nx][ny] == '0' && !visited[nx][ny][now.wall]) {
                    visited[nx][ny][now.wall] = true;
                    deque.addLast(new Point(nx, ny, now.dist + 1, now.wall));
                    if (nx == n - 1 && ny == m - 1) {
                        return now.dist + 1;
                    }
                }
                // 벽이고 부술 수 있을 때
                if (map[nx][ny] == '1' && now.wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    deque.addLast(new Point(nx, ny, now.dist + 1, 1));
                    if (nx == n - 1 && ny == m - 1) {
                        return now.dist + 1;
                    }
                }
            }
        }

        return -1;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Point {
    int x;
    int y;
    int dist;
    int wall;

    public Point(int x, int y, int dist, int wall) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.wall = wall;
    }
}
