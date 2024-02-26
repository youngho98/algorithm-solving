import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] route;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // route 생성
        route = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            route[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            route[x].add(y);
        }
        // bfs
        visited = new boolean[n + 1];
        visited[1] = true;
        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(new Node(start, 0));
        while (!deque.isEmpty()) {
            Node now = deque.pollFirst();
            for (int next : route[now.value]) {
                if (visited[next]) {
                    continue;
                }
                if (next == n) {
                    return now.dist + 1;
                }
                visited[next] = true;
                deque.addLast(new Node(next, now.dist + 1));
            }
        }
        return -1;
    }
}

class Node {
    int value, dist;

    public Node(int value, int dist) {
        this.value = value;
        this.dist = dist;
    }
}
