import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
            dp[i][1] = dp[i - 1][0] + arr[i];
            dp[i][2] = dp[i - 1][1] + arr[i];
        }

        int answer = Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
        System.out.println(answer);
    }
}