import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // map 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }
                if (i == n - 1 && j == n - 1) {
                    break;
                }
                int jump = map[i][j];
                if (i + jump < n) {
                    dp[i + jump][j] += dp[i][j];
                }
                if (j + jump < n) {
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
