import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] cost;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 비용 행렬 생성 후 초기화
        cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cost[i][j] = 1_000_000_000;
            }
        }

        // 버스 정보 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(c, cost[a][b]);
        }

        // 다익스트라
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dp = new int[n + 1];
        Arrays.fill(dp, 1_000_000_000);

        dijkstra(start, end);

        System.out.println(dp[end]);
    }

    static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dp[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.num == end) {
                return;
            }

            if (now.cost > dp[now.num]) {
                continue;
            }

            for (int i = 1; i <= n; i++) {
                if(now.cost + cost[now.num][i] < dp[i]) {
                    dp[i] = now.cost + cost[now.num][i];
                    pq.offer(new Node(i, dp[i]));
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