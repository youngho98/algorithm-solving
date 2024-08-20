import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 부모 배열
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 신 입력
        Point[] gods = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gods[i] = new Point(x, y);
        }

        // 이미 연결된 통로
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            if (union(x, y)) {
                cnt++;
            }
        }

        // 가능한 모든 통로
        PriorityQueue<Path> pq = new PriorityQueue<>(((o1, o2) -> (int) (o1.dist * 1000 - o2.dist * 1000)));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pq.add(new Path(i, j, calcDist(gods[i], gods[j])));
            }
        }

        // 크루스칼
        double answer = 0;
        while (true) {
            Path path = pq.poll();
            if (union(path.a, path.b)) {
                answer += path.dist;
                cnt++;
            }

            if (cnt == n - 1) {
                break;
            }
        }

        System.out.printf("%.2f", answer);
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
            return true;
        } else if (x > y) {
            parent[x] = y;
            return true;
        }
        return false;
    }

    static double calcDist(Point a, Point b) {
        return Math.sqrt(((long) (a.x - b.x) * (long) (a.x - b.x)) + ((long) (a.y - b.y) * (long) (a.y - b.y)));
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Path {
    int a, b;
    double dist;

    public Path(int a, int b, double dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}