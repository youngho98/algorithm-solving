import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] pw = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            pw[i] = input[i - 1] - 48;
        }

        if (pw[1] == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[pw.length];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < pw.length; i++) {
            if (pw[i] == 0) {
                if (pw[i - 1] >= 3 || pw[i - 1] == 0) {
                    System.out.println(0);
                    return;
                }
                dp[i] = dp[i - 2];
            } else {
                if (pw[i - 1] == 1) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                } else if (pw[i - 1] == 2 && pw[i] <= 6) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        System.out.println(dp[pw.length - 1]);
    }
}