import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][m];
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + map[i][j];
            }
        }

        int h = Integer.parseInt(br.readLine());

        if (h >= dp[n - 1][m - 1]) {
            System.out.println("YES");
            System.out.println(dp[n - 1][m - 1]);
        } else {
            System.out.println("NO");
        }
    }
}
