import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] dp = new long[100];
        dp[0] = dp[1] = dp[2] = 1;
        for (int i = 3; i < 100; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(dp[n - 1]);
        }
    }
}