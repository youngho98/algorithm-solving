import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 1개일 땐 int N = Integer.parseInt(br.readLine()); 으로 바로 받으면 됨 (이렇게 해도 상관은 없음)

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            if (S == 1) {

                int K = Integer.parseInt(st.nextToken());

                for (int i = K; i <= N; i += K) { // N도 포함해야 됨 i <= N 으로 수정
                    if (arr[i] == 0)
                        arr[i] = 1;
                    else
                        arr[i] = 0;
                }

            } else if (S == 2) {

                int K = Integer.parseInt(st.nextToken());

                int left = K;
                int right = K;
                if (arr[K] == 0) {
                    arr[K] = 1;
                } else {
                    arr[K] = 0;
                }

                while (--left > 0 && ++right <= N) {
                    if (arr[left] == arr[right]) {
                        if (arr[left] == 0) {
                            arr[left] = 1;
                        } else {
                            arr[left] = 0;
                        }
                        if (arr[right] == 0) {
                            arr[right] = 1;
                        } else {
                            arr[right] = 0;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= N; i++) { // N도 포함해야함. 앞과 마찬가지
            System.out.print(arr[i] + " ");

            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
