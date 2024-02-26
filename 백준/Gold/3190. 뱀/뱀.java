import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] snake = new boolean[n][n];

        // 사과 입력
        boolean[][] apple = new boolean[n][n];
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            apple[a][b] = true;
        }

        // 뱀의 방향 변환 정보 입력
        char[] turn = new char[10001];
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);
            turn[a] = b;
        }

        // 뱀의 이동
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int d = 0; // 방향
        int x = 0; // x 좌표
        int y = 0; // y 좌표
        int t = 0; // 시간

        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(x, y));
        snake[x][y] = true;
        while(true) {
            t++;
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 게임오버 (맵 밖으로)
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                System.out.println(t);
                break;
            }

            // 회전
            if (turn[t] == 'D') {
                d = (d + 1) % 4;
            } else if (turn[t] == 'L') {
                d = (d + 3) % 4;
            }

            // 사과를 먹으면
            if (apple[nx][ny]) {
                apple[nx][ny] = false;
            } else {
                Point out = deque.pollFirst();
                snake[out.x][out.y] = false;
            }

            // 게임오버 (뱀)
            if (snake[nx][ny]) {
                System.out.println(t);
                break;
            }

            // 다음칸으로 이동
            deque.addLast(new Point(x, y));
            snake[nx][ny] = true;
            x = nx;
            y = ny;
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}