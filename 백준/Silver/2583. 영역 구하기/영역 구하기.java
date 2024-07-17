import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            for (int j = n1; j < n2; j++) {
                for (int l = m1; l < m2; l++) {
                    map[j][l] = true;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> deque = new ArrayDeque<Point>();
        deque.addLast(new Point(x, y));
        map[x][y] = true;

        int cnt = 0;
        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny) && !map[nx][ny]) {
                    deque.addLast(new Point(nx, ny));
                    map[nx][ny] = true;
                }
            }
        }

        return cnt;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}