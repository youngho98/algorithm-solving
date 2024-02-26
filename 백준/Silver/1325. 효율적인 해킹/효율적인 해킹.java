import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] trust;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trust = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            trust[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trust[a].add(b);
        }

        // dfs
        count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(i);
        }

        // max 찾아 출력
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, count[i]);
        }

        for(int i = 1; i <= n; i++) {
            if (count[i] == max) {
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int node) {
        Deque<Integer> deque = new ArrayDeque<>();
        visited[node] = true;
        deque.addLast(node);
        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (int next : trust[now]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                count[next]++;
                deque.addLast(next);
            }
        }
    }
}