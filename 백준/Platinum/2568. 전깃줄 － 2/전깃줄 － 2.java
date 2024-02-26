import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[500001];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
            map.put(b, a);
        }

        int[] elec = new int[n];
        int idx = 0;
        for (int i = 1; i < 500001; i++) {
            if (arr[i] != 0) {
                elec[idx++] = arr[i];
            }
        }

        // 이분탐색
        int[] dp = new int[n];
        int[] lst = new int[n];
        int lstLen = 1;
        lst[0] = elec[0];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (elec[i] > lst[lstLen - 1]) {
                lst[lstLen++] = elec[i];
                dp[i] = lstLen;
            } else {
                int high = lstLen - 1;
                int low = 0;
                while (low < high) {
                    int mid = (high + low) / 2;
                    if (elec[i] > lst[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                lst[low] = elec[i];
                dp[i] = low + 1;
            }
        }

        int rmv = n - lstLen;

        // 역추적
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lstLen) {
                deque.offerFirst(elec[i]);
                lstLen--;
            }
            if (lstLen < 1) {
                break;
            }
        }

        // 남은 전봇대 제거 (제거할 전봇대 찾기)
        for (int i : deque) {
            map.remove(i);
        }

        int[] rmvLine = new int[rmv];
        idx = 0;
        for (int value : map.values()) {
            rmvLine[idx++] = value;
        }

        Arrays.sort(rmvLine);

        // 정답 출력
        System.out.println(rmv);
        for (int i : rmvLine) {
            System.out.println(i);
        }
    }
}