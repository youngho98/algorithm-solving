import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 50;
            int b = Integer.parseInt(st.nextToken()) + 50;
            int c = Integer.parseInt(st.nextToken()) + 50;

            if (a == 49 && b == 49 && c == 49) {
                break;
            }

            sb.append("w(").append(a - 50).append(", ").append(b - 50).append(", ").append(c - 50).append(") = ")
                    .append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c) {
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a <= 50 || b <= 50 || c <= 50) {
            dp[a][b][c] = 1;
            return dp[a][b][c];
        }
        if (a > 70 || b > 70 || c > 70) {
            dp[a][b][c] = w(70, 70, 70);
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            return dp[a][b][c];
        }
        dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}