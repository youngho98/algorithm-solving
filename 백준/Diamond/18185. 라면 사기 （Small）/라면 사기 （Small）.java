import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int price = 0;
        for (int i = 0; i < n - 2; i++) {
            while (arr[i + 1] > arr[i + 2] && arr[i] > 0 && arr[i + 1] > 0) {
                price += 5;
                arr[i]--;
                arr[i + 1]--;
            }
            while (arr[i] > 0 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                price += 7;
                arr[i]--;
                arr[i + 1]--;
                arr[i + 2]--;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            while (arr[i] > 0 && arr[i + 1] > 0) {
                price += 5;
                arr[i]--;
                arr[i + 1]--;
            }
        }
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0) {
                price += 3;
                arr[i]--;
            }
        }

        System.out.println(price);
    }
}