import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
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

        // 이분탐색
        int[] dp = new int[n];
        int[] lis = new int[n];
        int lisLen = 1;
        lis[0] = arr[0];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > lis[lisLen - 1]) {
                lis[lisLen] = arr[i];
                lisLen++;
                dp[i] = lisLen;
            } else {
                int high = lisLen - 1;
                int low = 0;
                while (low < high) {
                    int mid = (high + low) / 2;
                    if (lis[mid] < arr[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                lis[low]= arr[i];
                dp[i] = low + 1;
            }
        }

        System.out.println(lisLen);

        // 역추적
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lisLen) {
                deque.offerFirst(arr[i]);
                lisLen--;
            }
            if (lisLen < 1) {
                break;
            }
        }

        for (int i : deque) {
            System.out.print(i + " ");
        }
    }
}