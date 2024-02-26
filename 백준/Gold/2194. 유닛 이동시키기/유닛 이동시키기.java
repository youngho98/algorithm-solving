import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static boolean[][] visited;
    static int n, m, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 맵 생성 (장애물이 있으면 true)
        map = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = true;
        }

        // 시작점과 끝점 입력
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        // bfs
        visited = new boolean[n + 1][m + 1];
        visited[startX][startY] = true;
        System.out.println(bfs(startX, startY, endX, endY));
    }

    static int bfs(int startX, int startY, int endX, int endY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(startX, startY, 0));

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (canMove(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deque.addLast(new Point(nx, ny, now.dist + 1));
                    if (nx == endX && ny == endY) {
                        return now.dist + 1;
                    }
                }
            }
        }
        return -1;
    }

    static boolean canMove(int x, int y) {
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                int xp = x + i;
                int yp = y + j;
                if (!inMap(xp, yp) || map[xp][yp]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean inMap(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
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