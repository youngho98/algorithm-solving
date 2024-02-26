import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean isExist = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 인접 리스트 생성
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        // 친구관계 추가
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        // dfs
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
            if (isExist) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int node, int dist) {
        if (dist == 4) {
            isExist = true;
            return;
        }
        visited[node] = true;
        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next, dist + 1);
            }
        }
        visited[node] = false;
    }
}