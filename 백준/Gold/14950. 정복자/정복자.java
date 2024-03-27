import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 도로 입력
        Road[] roads = new Road[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            roads[i] = new Road(s, e, c);
        }

        Arrays.sort(roads, (o1, o2) -> o1.cost - o2.cost);

        // 유니온파인드 부모배열
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 크루스칼
        int total = 0;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int x = roads[i].start;
            int y = roads[i].end;
            if (!unionFind(x, y)) {
                union(x, y);
                total += roads[i].cost;
                cnt++;
            }
            if (cnt == n - 1) {
                break;
            }
        }

        // 추가비용 (도시 n개 = ((n - 1) * (n - 2) / 2) * t)
        total += ((n - 1) * (n - 2) / 2) * t;

        // 정답 출력
        System.out.println(total);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x > y) {
            parent[x] = y;
        } else if (x < y) {
            parent[y] = x;
        }
    }

    static boolean unionFind(int x, int y) {
        if (find(x) == find(y)) {
            return true;
        }
        return false;
    }
}

class Road {
    int start, end, cost;

    public Road(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}