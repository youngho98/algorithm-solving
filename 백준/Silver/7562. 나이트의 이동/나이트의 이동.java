import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            sb.append(bfs(n, sx, sy, ex, ey)).append("\n");
        }

        System.out.println(sb);
    }

    static int bfs(int n, int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) {
            return 0;
        }
        boolean[][] visited = new boolean[n][n];
        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        Deque<Point> dq = new ArrayDeque<>();
        dq.addLast(new Point(sx, sy, 0));
        visited[sx][sy] = true;

        while (!dq.isEmpty()) {
            Point now = dq.pollFirst();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx == ex && ny == ey) {
                    return now.dist + 1;
                }
                if (inMap(nx, ny, n) && !visited[nx][ny]) {
                    dq.addLast(new Point(nx, ny, now.dist + 1));
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
    }

    static boolean inMap(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
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