import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] count, direction, massSum, speedSum;
    static boolean[][] odd, even;
    static ArrayList<Ball> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            list.add(new Ball(x, y, mass, speed, dir));
        }

        for (int i = 0; i < k; i++) {
            count = new int[n][n];
            direction = new int[n][n];
            massSum = new int[n][n];
            speedSum = new int[n][n];
            odd = new boolean[n][n];
            even = new boolean[n][n];
            move();
            list.clear();
            combine();
        }

        int sum = 0;
        for (Ball b : list) {
            sum += b.mass;
        }
        System.out.println(sum);
    }

    static void move() {
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        for (Ball b : list) {
            int nx = (n + b.x + (dx[b.dir] * b.speed) % n) % n;
            int ny = (n + b.y + (dy[b.dir] * b.speed) % n) % n;

            // 갯수
            count[nx][ny]++;

            // 방향
            direction[nx][ny] = b.dir;
            if (b.dir % 2 == 0) {
                even[nx][ny] = true;
            } else {
                odd[nx][ny] = true;
            }

            // 질량
            massSum[nx][ny] += b.mass;

            // 속력
            speedSum[nx][ny] += b.speed;
        }
    }

    static void combine() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (count[i][j] == 1) {
                    list.add(new Ball(i, j, massSum[i][j], speedSum[i][j], direction[i][j]));
                } else if (count[i][j] > 1 && massSum[i][j] / 5 > 0) {
                    if ((odd[i][j] && !even[i][j]) || (!odd[i][j] && even[i][j])) {
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 0));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 2));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 4));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 6));
                    } else {
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 1));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 3));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 5));
                        list.add(new Ball(i, j, massSum[i][j] / 5, speedSum[i][j] / count[i][j], 7));
                    }
                }
            }
        }
    }
}

class Ball {
    int x, y, mass, speed, dir;

    public Ball(int x, int y, int mass, int speed, int dir) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.speed = speed;
        this.dir = dir;
    }
}