import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 트리 생성
        int n = Integer.parseInt(br.readLine());
        long[] cnt = new long[n + 1];
        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
            cnt[a]++;
            cnt[b]++;
        }

        // ㄷ 트리 찾기
        long dTree = 0;
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        visited[1] = true;
        deque.addLast(1);

        while(!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (int next : tree[now]) {
                if (!visited[next]) {
                    dTree += (cnt[now] - 1) * (cnt[next] - 1);
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }

        // ㅈ 트리 찾기
        long gTree = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] >= 3) {
                gTree += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
            }
        }

        // 출력
        if (dTree > gTree * 3) {
            System.out.println("D");
        } else if (dTree < gTree * 3) {
            System.out.println("G");
        } else {
            System.out.println("DUDUDUNGA");
        }
    }
}