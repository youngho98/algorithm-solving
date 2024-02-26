import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dp = new int[n][n];
        // 삼각형 채우기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dp
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + map[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + map[i][j];
            }
        }
        // 최대값 찾기
        int max = dp[n-1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n-1][i] > max) {
                max = dp[n-1][i];
            }
        }
        // 출력
        System.out.println(max);
    }
}