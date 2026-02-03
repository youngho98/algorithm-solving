import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[1001][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l][0] = h;
            arr[l][1] = h;
        }

        for (int i = 1; i <= 1000; i++) {
            arr[i][0] = Math.max(arr[i - 1][0], arr[i][0]);
        }

        for (int i = 999; i >= 0; i--) {
            arr[i][1] = Math.max(arr[i + 1][1], arr[i][1]);
        }

        int ans = 0;
        for (int i = 0; i <= 1000; i++) {
            ans += Math.min(arr[i][0], arr[i][1]);
        }

        System.out.println(ans);
    }
}
