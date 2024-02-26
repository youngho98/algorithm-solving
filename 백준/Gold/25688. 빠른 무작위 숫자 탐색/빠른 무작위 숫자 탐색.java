import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // bfs
        System.out.println(bfs(r, c));
    }

    static int bfs(int r, int c) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(r, c, 0, 0));
        int repeat = 0;
        while (repeat < 1_000_000) {
            Point now = deque.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny)) {
                    int nextCheck = checking(now.check, map[nx][ny]);
                    if (nextCheck == 63) {
                        return now.dist + 1;
                    }
                    deque.addLast(new Point(nx, ny, now.dist + 1, nextCheck));
                }
            }
            repeat++;
        }
        return -1;
    }

    static boolean inMap(int x, int y) {
        if (0 <= x && x <= 4 && 0 <= y && y <= 4) {
            return map[x][y] != -1;
        }
        return false;
    }

    static int checking(int input, int num) {
        switch (num) {
            case 1:
                if ((input & 32) != 32) {
                    return input + 32;
                }
                break;
            case 2:
                if ((input & 16) != 16) {
                    return input + 16;
                }
                break;
            case 3:
                if ((input & 8) != 8) {
                    return input + 8;
                }
                break;
            case 4:
                if ((input & 4) != 4) {
                    return input + 4;
                }
                break;
            case 5:
                if ((input & 2) != 2) {
                    return input + 2;
                }
                break;
            case 6:
                if ((input & 1) != 1) {
                    return input + 1;
                }
                break;
            default:
        }
        return input;
    }
}

class Point {
    int x, y, dist, check;

    public Point(int x, int y, int dist, int check) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.check = check;
    }
}