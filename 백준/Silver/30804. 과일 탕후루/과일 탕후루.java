import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                int cnt = 0;
                for (int k = 0; k < n ; k++) {
                    if (arr[k] == i || arr[k] == j) {
                        cnt++;
                        if (max < cnt) {
                            max = cnt;
                        }
                    } else {
                        cnt = 0;
                    }
                }
            }
        }
        System.out.println(max);
    }
}