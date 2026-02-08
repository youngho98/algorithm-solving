import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        if (k > n * m) {
            System.out.println(0);
            return;
        }

        int[] answer = findAnswer(k);
        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] findAnswer(int k) {
        int[][] map = new int[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int num = 1;
        int x = 0;
        int y = 0;
        int dir = 0;

        while (num < k) {
            map[x][y] = num++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (inMap(nx, ny) && map[nx][ny] == 0) {
                x = nx;
                y = ny;
            } else {
                dir = (dir + 1) & 3;
                x += dx[dir];
                y += dy[dir];
            }
        }

        return new int[]{x + 1, y + 1};
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
