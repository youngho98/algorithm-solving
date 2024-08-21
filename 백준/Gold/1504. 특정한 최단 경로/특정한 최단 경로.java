import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static ArrayList<Path>[] paths;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        paths = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            paths[i] =  new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            paths[a].add(new Path(b, c));
            paths[b].add(new Path(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = calcDist(1, v1) + calcDist(v1, v2) + calcDist(v2, n);
        int ans2 = calcDist(1, v2) + calcDist(v2, v1) + calcDist(v1, n);

        int answer = Math.min(ans1, ans2);
        if (answer >= 100_000_000) {
            answer = -1;
        }
        System.out.println(answer);
    }

    static int calcDist(int from, int to) {

        if (from == to) {
            return 0;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Node(from, 0));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100_000_000);
        dp[from] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Path path : paths[now.num]) {
                Node next = new Node(path.target, now.dist + path.dist);
                if (next.dist < dp[next.num]) {
                    pq.add(next);
                    dp[next.num] = next.dist;
                }
            }
        }

        return dp[to];
    }
}

class Path {
    int target, dist;

    public Path(int target, int dist) {
        this.target = target;
        this.dist = dist;
    }
}

class Node {
    int num, dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }
}