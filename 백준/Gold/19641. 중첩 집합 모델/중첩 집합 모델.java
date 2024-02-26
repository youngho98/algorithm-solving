import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer>[] model;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 인접 리스트 생성
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    break;
                }
                tree[node].add(num);
            }
        }
        // 번호가 낮은 노드부터 방문하게끔 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(tree[i]);
        }

        // dfs
        visited = new boolean[n + 1];
        model = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            model[i] = new ArrayList<>();
        }

        int root = Integer.parseInt(br.readLine());
        visited[root] = true;
        dfs(root);

        // 출력
        for (int i = 1; i <= n; i++) {
            bw.write(i + " ");
            for (int num : model[i]) {
                bw.write(num + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int node) {
        model[node].add(++cnt);
        for (int next : tree[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
        model[node].add(++cnt);
    }
}