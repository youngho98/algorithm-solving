import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        // n 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // dp[k][0] : k자리의 숫자 중 끝이 0인 이친수의 개수
        // dp[k][1] : k자리의 숫자 중 끝이 1인 이친수의 개수
        long[][] dp = new long[n + 1][2];    // N이 90까지 들어올 수 있어 long으로 선언해야 함
        dp[1][1] = 1;   // 1자리 이친수는 1 한개만 있다.

        // 2자리 이친수부터는 한자리 낮은 이친수의 개수를 이용하여 dp로 구한다.
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1]; // 한자리 낮은 모든 이친수에다가 0을 붙이면 그 수도 이친수이다.
            dp[i][1] = dp[i - 1][0];                // 한자리 낮은 이친수 중 0으로 끝나는 수에다가 1을 붙이면 그 수도 이친수이다.
        }

        // 출력
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
