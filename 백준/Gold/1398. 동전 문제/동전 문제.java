import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // dp 테이블 생성
        int[] dp = new int[100];
        for (int i = 0; i < 100; i++) {
            if (i >= 25) {
                dp[i] = Math.min(Math.min(dp[i - 25] + 1, dp[i - 10] + 1), dp[i - 1] + 1);
            } else if (i >= 10) {
                dp[i] = Math.min(dp[i - 10] + 1, dp[i - 1] + 1);
            } else {
                dp[i] = i;
            }
        }

        // 테스트 케이스
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            long price = Long.parseLong(br.readLine());

            int cnt = 0;
            while (price > 0) {
                cnt += dp[(int)(price % 100)];
                price /= 100;
            }

            sb.append(cnt).append("\n");
        }

        // 정답 출력
        System.out.println(sb);
    }
}