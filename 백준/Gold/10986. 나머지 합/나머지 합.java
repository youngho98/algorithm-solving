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

        st = new StringTokenizer(br.readLine());
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = (prefix[i - 1] + Integer.parseInt(st.nextToken())) % m;
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            long cnt = 0;
            for (int j = 0; j <= n; j++) {
                if (prefix[j] == i) {
                    cnt++;
                }
            }
            answer += cnt * (cnt - 1) / 2;
        }

        System.out.println(answer);
    }
}