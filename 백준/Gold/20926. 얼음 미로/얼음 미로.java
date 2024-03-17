import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[][] time, dp;
    static int w, h, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        // 맵 입력
        char[][] map = new char[h][w];
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 미로의 미끌시간
        time = new int[h][w];
        int startX = 0;
        int startY = 0;
        endX = 0;
        endY = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ('0' <= map[i][j] && map[i][j] <= '9') {
                    time[i][j] = map[i][j] - '0';
                } else if (map[i][j] == 'T') { // 테라의 위치
                    time[i][j] = 0;
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'R') {
                    time[i][j] = -1;
                } else if (map[i][j] == 'H') {
                    time[i][j] = -2;
                } else if (map[i][j] == 'E') {
                    time[i][j] = -3;
                    endX = i;
                    endY = j;
                }
            }
        }

        // 위치별 최단시간 dp
        dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dp[i], 100_000_000);
        }

        // 다익스트라
        dijkstra(startX, startY);

        // 정답 출력
        if (dp[endX][endY] == 100_000_000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[endX][endY]);
        }
    }

    static void dijkstra(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dp[x][y] = 0;
        pq.offer(new Point(x, y, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int i = 0; i < 4; i++) {
                Point next = go(now.x, now.y, now.cost, i);
                if (next.x == -1) {
                    continue;
                }
                if (dp[next.x][next.y] > next.cost) {
                    dp[next.x][next.y] = next.cost;
                    if (!(next.x == endX && next.y == endY)) {
                        pq.offer(new Point(next.x, next.y, next.cost));
                    }
                }
            }
        }
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < h && 0 <= y && y < w;
    }

    static Point go(int x, int y, int cost, int d) { // d -> 0:up / 1:down / 2:left / 3:right
        while (true) {
            switch (d) {
                case 0:
                    x--;
                    break;
                case 1:
                    x++;
                    break;
                case 2:
                    y--;
                    break;
                case 3:
                    y++;
            }
            if (inMap(x, y)) {
                if (time[x][y] >= 0) {
                    cost += time[x][y];
                } else if (time[x][y] == -1) {
                    switch (d) {
                        case 0:
                            x++;
                            break;
                        case 1:
                            x--;
                            break;
                        case 2:
                            y++;
                            break;
                        case 3:
                            y--;
                    }
                    return new Point(x, y, cost);
                } else if (time[x][y] == -2) {
                    return new Point(-1, -1, -1);
                } else if (time[x][y] == -3) {
                    return new Point(x, y, cost);
                }
            } else {
                return new Point(-1, -1, -1);
            }
        }
    }
}

class Point {
    int x, y, cost;

    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}