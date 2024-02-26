import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        ArrayList<Integer>[] dp = new ArrayList[n];
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = new ArrayList<>();
            cnt[i] = 1;
        }
        int ans = 0;
        int ii = 0;
        for (int i = 0; i < n; i++) {
            int max = 1;
            int idx = -1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && cnt[j] + 1 > max) {
                    max = cnt[j] + 1;
                    idx = j;
                }
            }
            cnt[i] = max;
            if (idx != -1) {
                for (int num : dp[idx]) {
                    dp[i].add(num);
                }
            }
            dp[i].add(arr[i]);
            if (cnt[i] > ans) {
                ans = cnt[i];
                ii = i;
            }
        }
        System.out.println(ans);
        for (int num : dp[ii]) {
            System.out.print(num + " ");
        }
    }
}