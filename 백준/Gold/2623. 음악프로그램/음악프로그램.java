import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 인접리스트 & 카운트배열 생성
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int[] cnt = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int[] order = new int[k];
            for (int j = 0; j < k; j++) {
                order[j] = Integer.parseInt(st.nextToken());
                cnt[order[j]] += j;
            }

            for (int j = 0; j < k; j++) {
                for (int l = j + 1; l < k; l++) {
                    list[order[j]].add(order[l]);
                }
            }
        }

        // 위상정렬 탐색
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                deque.addLast(i);
            }
        }

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            sb.append(now).append("\n");

            for (int next : list[now]) {
                if (--cnt[next] == 0) {
                    deque.addLast(next);
                }
            }
        }

        // 정답 출력
        boolean possible = true;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] != 0) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println(sb);
        } else {
            System.out.println(0);
        }
    }
}