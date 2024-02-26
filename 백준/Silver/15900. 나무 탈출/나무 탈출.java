import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int distSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 인접 리스트 생성
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        // dfs
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);
        // 승리가능 판별 (distSum이 홀수면 승리가능)
        if (distSum % 2 == 1) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int node, int dist) {
        boolean isLeap = true;
        for (int i : tree[node]) {
            if (!visited[i]) {
                isLeap = false;
                visited[i] = true;
                dfs(i, dist + 1);
            }
        }
        if (isLeap) {
            distSum += dist;
        }
    }
}