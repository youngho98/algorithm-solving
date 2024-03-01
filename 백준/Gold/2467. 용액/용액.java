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

        int start = 0;
        int end = n - 1;
        int minVal = Integer.MAX_VALUE;
        int sol1 = 0;
        int sol2 = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (Math.abs(sum) < minVal) {
                sol1 = arr[start];
                sol2 = arr[end];
                minVal = Math.abs(sum);
            }
            if (sum > 0) {
                end--;
            } else if (sum < 0) {
                start++;
            } else {
                break;
            }
        }

        System.out.println(sol1 + " " + sol2);
    }
}