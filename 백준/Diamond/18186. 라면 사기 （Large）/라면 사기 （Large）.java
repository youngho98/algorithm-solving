import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        // 구매할 라면 갯수 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long price = 0;
        // 하나씩 사는 것보다 묶어서 사는게 싼 경우
        if (b > c) {
            for (int i = 0; i < n - 2; i++) {
                if (arr[i + 1] > arr[i + 2] && arr[i] > 0) {
                    int min = Math.min(arr[i + 1] - arr[i + 2], arr[i]);
                    price += (b + c) * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                }
                if (arr[i] > 0 && arr[i + 1] > 0 && arr[i + 2] > 0) {
                    int min = Math.min(Math.min(arr[i], arr[i + 1]), arr[i + 2]);
                    price += (b + c * 2) * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                    arr[i + 2] -= min;
                }
            }
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > 0 && arr[i + 1] > 0) {
                    int min = Math.min(arr[i], arr[i + 1]);
                    price += (b + c) * min;
                    arr[i] -= min;
                    arr[i + 1] -= min;
                }
            }
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    price += b * arr[i];
                    arr[i] = 0;
                }
            }
        } else { // b <= c 이면 전부 1개씩 구매해도 됨
            for (int i = 0; i < n; i++) {
                price += b * arr[i];
            }
        }

        System.out.println(price);
    }
}