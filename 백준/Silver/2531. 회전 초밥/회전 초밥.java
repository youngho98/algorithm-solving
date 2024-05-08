import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 초밥
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // k개씩 연속으로 먹는 경우
        int[] cnt = new int[d + 1];
        int count = 1;
        int max = 1;
        cnt[c] = 1;
        for (int i = 0; i < k; i++) {
            if (cnt[arr[i]]++ == 0) {
                count++;
            }
        }

        for (int i = 0; i + k < n; i++) {
            if (--cnt[arr[i]] == 0) {
                count--;
            }
            if (cnt[arr[i + k]]++ == 0) {
                count++;
            }
            max = Math.max(count, max);
        }

        for (int i = n - k; i < n; i++) {
            if (--cnt[arr[i]] == 0) {
                count--;
            }
            if (cnt[arr[i - n + k]]++ == 0) {
                count++;
            }
            max = Math.max(count, max);
        }

        System.out.println(max);
    }
}