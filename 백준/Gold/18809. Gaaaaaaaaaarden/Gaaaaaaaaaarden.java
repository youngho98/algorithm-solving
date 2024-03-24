import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] temp;
    static int n, m, g, r, len, max_flower;
    static int[][] garden, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 정원 & 스타트지점 입력
        garden = new int[n][m];
        start = new int[10][];
        len = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());
                if (garden[i][j] == 2) {
                    start[len++] = new int[]{i, j};
                }
            }
        }

        // 조합 백트래킹
        max_flower = 0;
        temp = new int[len];
        combination(0, 0, 0);

        // 정답 출력
        System.out.println(max_flower);
    }

    static void combination(int idx, int green, int red) {
        if (green > g || red > r) {
            return;
        }
        if (idx == len) {
            if (green == g && red == r) {
                max_flower = Math.max(bfs(), max_flower);
            }
            return;
        }
        combination(idx + 1, green, red);
        temp[idx] = 1;
        combination(idx + 1, green + 1, red);
        temp[idx] = 2;
        combination(idx + 1, green, red + 1);
        temp[idx] = 0;
    }

    static int bfs() {
        int cnt = 0;
        boolean[][] flower = new boolean[n][m];
        int[][] greenDist = new int[n][m];
        int[][] redDist = new int[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<Fluid> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (temp[i] == 1) {
                deque.addLast(new Fluid(start[i][0], start[i][1], 1, 1));
                greenDist[start[i][0]][start[i][1]] = 1;
            } else if (temp[i] == 2) {
                deque.addLast(new Fluid(start[i][0], start[i][1], 1, 2));
                redDist[start[i][0]][start[i][1]] = 1;
            }
        }

        while (!deque.isEmpty()) {
            Fluid now = deque.pollFirst();
            if (flower[now.x][now.y]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (!inMap(nx, ny) || garden[nx][ny] == 0) {
                    continue;
                }
                if (now.gr == 1) {
                    if (redDist[nx][ny] == now.dist + 1) {
                        flower[nx][ny] = true;
                    }
                    if (greenDist[nx][ny] == 0 && redDist[nx][ny] == 0) {
                        deque.addLast(new Fluid(nx, ny, now.dist + 1, now.gr));
                        greenDist[nx][ny] = now.dist + 1;
                    }
                } else {
                    if (greenDist[nx][ny] == now.dist + 1) {
                        flower[nx][ny] = true;
                    }
                    if (greenDist[nx][ny] == 0 && redDist[nx][ny] == 0) {
                        deque.addLast(new Fluid(nx, ny, now.dist + 1, now.gr));
                        redDist[nx][ny] = now.dist + 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (flower[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Fluid {
    int x, y, dist, gr;

    public Fluid(int x, int y, int dist, int gr) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.gr = gr;
    }
}