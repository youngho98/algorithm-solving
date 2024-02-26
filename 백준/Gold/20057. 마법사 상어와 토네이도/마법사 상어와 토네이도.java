import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int out, n;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시간에 따른 방향 회전 여부
        boolean[] time = new boolean[n * n + 1];
        for (int i = 1; i <= n; i++) {
            time[i * (i - 1)] = true;
            time[i * i] = true;
        }

        // 시뮬레이션
        int x = n / 2; // x 좌표
        int y = n / 2; // y 좌표
        int d = 0; // 방향
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        int t = 0; // 시간

        while (t < n * n - 1) {
            t++;
            x += dx[d];
            y += dy[d];
            tornado(x, y, d);
            if (time[t]) {
                d = (d + 1) % 4;
            }
        }

        System.out.println(out);
    }

    // 방향과 도착위치를 바탕으로 토네이도 실행
    static void tornado(int x, int y, int d) {
        int sand = map[x][y];
        map[x][y] = 0;
        if (d == 0) {
            int[] dx = {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0};
            int[] dy = {0, 0, 1, 1, 0, 0, -1, -1, -2, -1};
            tornadoWind(x, y, dx, dy, sand);
        } else if (d == 1) {
            int[] dx = {0, 0, -1, -1, 0, 0, 1, 1, 2, 1};
            int[] dy = {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0};
            tornadoWind(x, y, dx, dy, sand);
        } else if (d == 2) {
            int[] dx = {1, -1, 1, -1, 2, -2, 1, -1, 0, 0};
            int[] dy = {0, 0, -1, -1, 0, 0, 1, 1, 2, 1};
            tornadoWind(x, y, dx, dy, sand);
        } else {
            int[] dx = {0, 0, 1, 1, 0, 0, -1, -1, -2, -1};
            int[] dy = {-1, 1, -1, 1, -2, 2, -1, 1, 0, 0};
            tornadoWind(x, y, dx, dy, sand);
        }
    }

    // 토네이도가 실행될 때 각 칸마다 모래의 이동량
    static void tornadoWind (int x, int y, int[] dx, int[] dy, int sand){
        for (int i = 0; i < 10; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (i < 2) {
                sandMove(nx, ny, sand, 0.07);
            } else if (i < 4) {
                sandMove(nx, ny, sand, 0.01);
            } else if (i < 6) {
                sandMove(nx, ny, sand, 0.02);
            } else if (i < 8) {
                sandMove(nx, ny, sand, 0.1);
            } else if (i < 9) {
                sandMove(nx, ny, sand, 0.05);
            } else {
                sand -= (int) (0.07 * sand) * 2 + (int) (0.01 * sand) * 2 + (int) (0.02 * sand) * 2
                        + (int) (0.1 * sand) * 2 + (int) (0.05 * sand);
                if (inMap(nx, ny)) {
                    map[nx][ny] += sand;
                } else {
                    out += sand;
                }
            }
        }
    }

    // 모래의 이동 구현
    static void sandMove(int nx, int ny, int sand, double amount) {
        if (inMap(nx, ny)) {
            map[nx][ny] += (int) (amount * sand);
        } else {
            out += (int) (amount * sand);
        }
    }

    // 맵 안에 있는지 판별
    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}