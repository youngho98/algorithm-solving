import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new boolean[100][100];

        // 색종이 입력
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    map[j][k] = true;
                }
            }
        }

        // 둘레 카운트
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) {
                    sum += check(i, j);
                }
            }
        }

        System.out.println(sum);
    }

    static int check(int x, int y) {
        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1 ,1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inMap(nx, ny) || !map[nx][ny]) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < 100 && 0 <= y && y < 100;
    }
}