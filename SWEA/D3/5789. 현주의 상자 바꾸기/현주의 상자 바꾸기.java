import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] box = new int[n + 1];
            for (int i = 1; i <= q; i++) {
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                for (int j = l; j <= r; j++) {
                    box[j] = i;
                }
            }

            System.out.print("#" + t);
            for (int i = 1; i <= n; i++) {
                System.out.print(" " + box[i]);
            }
            System.out.println();
        }
    }
}