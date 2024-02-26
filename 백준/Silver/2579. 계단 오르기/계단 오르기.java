import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];
        dp1[1] = dp2[1] = stairs[1];
        for (int i = 2; i <= n; i++) {
            dp1[i] = Math.max(dp1[i - 2], dp2[i - 2]) + stairs[i];
            dp2[i] = dp1[i - 1] + stairs[i];
        }

        System.out.println(Math.max(dp1[n], dp2[n]));
    }
}