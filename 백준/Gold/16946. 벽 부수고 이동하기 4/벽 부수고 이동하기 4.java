import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] map;
    static int[][] dp;
    static int[] size = new int[1_000_001];
    static int check = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0' && dp[i][j] == 0) {
                    bfs(i, j);
                    check++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '0') {
                    sb.append(0);
                } else {
                    int cnt = 1;
                    HashSet<Integer> set = new HashSet<>();
                    if (i > 0) {
                        set.add(dp[i - 1][j]);
                    }
                    if (i < n - 1) {
                        set.add(dp[i + 1][j]);
                    }
                    if (j > 0) {
                        set.add(dp[i][j - 1]);
                    }
                    if (j < m - 1) {
                        set.add(dp[i][j + 1]);
                    }
                    for (int num : set) {
                        cnt += size[num];
                    }
                    sb.append(cnt % 10);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        int cnt = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(x, y));
        dp[x][y] = check;

        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny) && map[nx][ny] == '0' && dp[nx][ny] == 0) {
                    deque.addLast(new Point(nx, ny));
                    dp[nx][ny] = check;
                }
            }
        }

        cnt %= 10;
        size[check] = cnt;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}