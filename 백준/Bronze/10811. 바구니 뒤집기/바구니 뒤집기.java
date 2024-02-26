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

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int[] result = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());

            for (int j = 0; j < a; j++) {
                result[j] = arr[j];
            }
            for (int j = a; j <= b; j++) {
                result[j] = arr[a + b - j];
            }
            for (int j = b + 1; j <= n; j++) {
                result[j] = arr[j];
            }

            for (int j = 1; j <= n; j++) {
                arr[j] = result[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}