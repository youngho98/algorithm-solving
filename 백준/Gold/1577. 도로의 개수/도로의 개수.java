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
        int k = Integer.parseInt(br.readLine());

        // 막힌 도로
        int[] startX = new int[k];
        int[] startY = new int[k];
        int[] endX = new int[k];
        int[] endY = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken()) + 1;
            int ay = Integer.parseInt(st.nextToken()) + 1;
            int bx = Integer.parseInt(st.nextToken()) + 1;
            int by = Integer.parseInt(st.nextToken()) + 1;
            if (ax == bx) {
                startX[i] = ax;
                endX[i] = ax;
                startY[i] = Math.min(ay, by);
                endY[i] = Math.max(ay, by);
            } else {
                startX[i] = Math.min(ax, bx);
                endX[i] = Math.max(ax, bx);
                startY[i] = ay;
                endY[i] = ay;
            }
        }

        // dp
        long[][] dp = new long[n + 2][m + 2];
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= m + 1; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = 1;
                    continue;
                }
                boolean canDown = true;
                boolean canRight = true;
                for (int l = 0; l < k; l++) {
                    if (endX[l] == i && endY[l] == j) {
                        if (startX[l] == i - 1 && startY[l] == j) {
                            canDown = false;
                        } else if (startX[l] == i && startY[l] == j - 1) {
                            canRight = false;
                        }
                    }
                }
                if (canDown && canRight) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else if (canDown) {
                    dp[i][j] = dp[i - 1][j];
                } else if (canRight) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(dp[n + 1][m + 1]);
    }
}