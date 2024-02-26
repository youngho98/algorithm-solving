// 출근

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static int[] dx, dy;
    static boolean[][] visited;
    static int r, c, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    map[i][j] = true;
                }
            }
        }

        n = Integer.parseInt(br.readLine());
        dx = new int[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            dx[i] = Integer.parseInt(st.nextToken());
            dy[i] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[r][c];
        System.out.println(bfs(0));
    }

    static int bfs(int a) {
        Deque<Point> deque = new ArrayDeque<>();
        for (int i = 0; i < c; i++) {
            if (map[a][i]) {
                visited[a][i] = true;
                deque.offerLast(new Point(a, i, 0));
            }
        }

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            for (int i = 0; i < n; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny) && map[nx][ny] && !visited[nx][ny]) {
                    if (nx == r - 1) {
                        return now.dist + 1;
                    }
                    visited[nx][ny] = true;
                    deque.offerLast(new Point(nx, ny, now.dist + 1));
                }
            }
        }
        return -1;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < r && 0 <= y && y < c;
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
