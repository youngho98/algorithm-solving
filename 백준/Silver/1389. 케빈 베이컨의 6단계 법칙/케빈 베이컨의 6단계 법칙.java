import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] connect;
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        connect = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            connect[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            connect[a].add(b);
            connect[b].add(a);
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (bfs(i) < min) {
                min = bfs(i);
                ans = i;
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int num) {
        boolean[] visited = new boolean[n + 1];
        int[] bacon = new int[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(num);
        visited[num] = true;
        while (!deque.isEmpty()) {
            int node = deque.pollFirst();
            for (int next : connect[node]) {
                if (!visited[next]) {
                    deque.addLast(next);
                    visited[next] = true;
                    bacon[next] = bacon[node] + 1;
                }
            }
        }
        int sum = 0;
        for (int cnt : bacon) {
            sum += cnt;
        }
        return sum;
    }
}