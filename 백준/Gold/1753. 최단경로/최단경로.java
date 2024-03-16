import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]>[] costs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        // 비용 행렬 생성
        costs = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            costs[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            costs[a].add(new int[]{b, w});
        }

        // 다익스트라
        dp = new int[v + 1];
        Arrays.fill(dp, 100_000_000);
        dijkstra(k);

        // 출력
        for (int i = 1; i <= v; i++) {
            if (dp[i] == 100_000_000) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dp[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.offer(new Node(k, 0));
        dp[k] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int[] next : costs[now.num]) {
                if (next[1] + now.cost < dp[next[0]]) {
                    dp[next[0]] = next[1] + now.cost;
                    pq.offer(new Node(next[0], dp[next[0]]));
                }
            }
        }
    }
}

class Node {
    int num, cost;

    public Node(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }
}