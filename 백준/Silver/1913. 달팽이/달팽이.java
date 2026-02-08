import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n, k;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        makeSnail();

        System.out.println(makeAnswer());
    }

    private static void makeSnail() {
        map = new int[n][n];

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0;
        int c = 0;
        int dir = 0;
        int num = n * n;

        while (num > 0) {
            map[r][c] = num--;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (inMap(nr, nc) && map[nr][nc] == 0) {
                r = nr;
                c = nc;
            } else {
                dir = (dir + 1) & 3;
                r += dr[dir];
                c += dc[dir];
            }
        }
    }

    private static boolean inMap(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    private static String makeAnswer() {
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
                if (map[i][j] == k) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(ans[0]).append(" ").append(ans[1]);

        return sb.toString();
    }
}
