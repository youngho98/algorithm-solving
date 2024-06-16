import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());
        for (int t = 1; t <= p; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            cnt = 0;
            int[] arr = new int[20];
            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 20; i++) {
                arr = line(i, arr);
            }

            sb.append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static int[] line(int k, int[] arr) {
        for (int i = 0; i < k; i++) {
            if (arr[i] > arr[k]) {
                cnt += k - i;
                int temp = arr[k];
                for (int j = k; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[i] = temp;
                break;
            }
        }
        return arr;
    }
}