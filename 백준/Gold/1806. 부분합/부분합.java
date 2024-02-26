import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        while (end < n - 1) {
            if (sum >= s) {
                min = Math.min(min, end - start + 1);
                sum -= arr[start++];
            } else {
                sum += arr[++end];
            }
        }
        while (sum >= s) {
            min = Math.min(min, end - start + 1);
            sum -= arr[start++];
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}