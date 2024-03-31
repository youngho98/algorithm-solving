import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < arr[i] + 1; j++) {
                if (dp[i] == Integer.MAX_VALUE) {
                    break;
                }
                if (i + j < n) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n - 1]);
        }
    }
}