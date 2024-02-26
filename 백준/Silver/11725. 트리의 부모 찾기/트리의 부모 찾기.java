import java.io.*;
import java.util.*;

public class Main {
    public static int[] parents;
    public static int n;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        parents = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
    public static void bfs(int num) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(num);
        visited[num] = true;
        while (!dq.isEmpty()) {
            int node = dq.pollFirst();
            for (int i : list[node]) {
                if (!visited[i]) {
                    dq.addLast(i);
                    visited[i] = true;
                    parents[i] = node;
                }
            }
        }
    }
}