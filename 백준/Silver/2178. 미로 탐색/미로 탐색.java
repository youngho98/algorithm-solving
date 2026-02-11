import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int n, m;
    private static char[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> dq = new ArrayDeque<Point>();
        dq.addLast(new Point(0, 0, 1));
        map[0][0] = '0';

        while (!dq.isEmpty()) {
            Point now = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny) && map[nx][ny] == '1') {
                    if (nx == n - 1 && ny == m - 1) {
                        return now.dist + 1;
                    }
                    dq.addLast(new Point(nx, ny, now.dist + 1));
                    map[nx][ny] = '0';
                }
            }
        }
        return 0;
    }

    private static boolean inMap(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}

class Point {
    int x, y, dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
