import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean cycle = false;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        visited = new boolean[n + 1];
        dfs(1);
        if (cycle) {
            System.out.println("CYCLE");
        } else {
            System.out.println("NO CYCLE");
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i : list[node]) {
            if (visited[i]) {
                cycle = true;
                return;
            }
            dfs(i);
        }
        visited[node] = false;
    }
}