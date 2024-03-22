import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 모든 조합 경우의 수
            int min = Integer.MAX_VALUE;
            for (int bit = 0; bit < (1<<n); bit++) {
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if ((bit & (1<<i)) > 0) {
                        sum += arr[i];
                    }
                }
                if (sum >= b) {
                    min = Math.min(min, sum - b);
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
}
