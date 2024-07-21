import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기 연병장의 높이
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 명령 (누적합 적용 전)
        int[] cmd = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cmd[a] += k;
            cmd[b] -= k;
        }

        // 명령 (누적합 적용 후)
        int[] sum = new int[n];
        sum[0] = cmd[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + cmd[i];
        }

        // 출력
        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + sum[i]).append(" ");
        }

        System.out.println(sb);
    }
}