import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long minVal = Long.MAX_VALUE;
        long[] sol = new long[3];
        out: for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (true) {
                if (start == i) {
                    start++;
                } else if (end == i) {
                    end--;
                }
                if (start == end) {
                    break;
                }

                long sum = arr[i] + arr[start] + arr[end];
                if (minVal > Math.abs(sum)) {
                    minVal = Math.abs(sum);
                    sol[0] = arr[i];
                    sol[1] = arr[start];
                    sol[2] = arr[end];
                }

                if (sum > 0) {
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    break out;
                }
            }
        }

        Arrays.sort(sol);
        System.out.println(sol[0] + " " + sol[1] + " " + sol[2]);
    }
}