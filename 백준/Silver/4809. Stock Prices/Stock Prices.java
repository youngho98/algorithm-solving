import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            st = new StringTokenizer(br.readLine());
            int[][] price = new int[n][2];
            for (int i = 0; i < n; i++) {
                price[i] = new int[] {Integer.parseInt(st.nextToken()), i + 1};
            }

            Arrays.sort(price, (o1, o2) -> o1[0] - o2[0]);

            ArrayList<Integer> low = new ArrayList<>();
            ArrayList<Integer> high = new ArrayList<>();
            for (int i = 0; i < k1; i++) {
                low.add(price[i][1]);
            }
            for (int i = n - 1; i >= n - k2; i--) {
                high.add(price[i][1]);
            }

            Collections.sort(low);
            Collections.sort(high, Collections.reverseOrder());

            t++;
            sb.append("Case ").append(t).append("\n");
            for (int i : low) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            for (int i : high) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}