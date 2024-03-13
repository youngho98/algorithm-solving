import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        double[][] star = new double[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            star[i][0] = Double.parseDouble(st.nextToken()); // x 좌표
            star[i][1] = Double.parseDouble(st.nextToken()); // y 좌표
        }

        // 간선 입력
        Line[] lines = new Line[n * (n - 1) / 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = distance(star[i][0], star[i][1], star[j][0], star[j][1]);
                lines[idx++] = new Line(dist, i, j);
            }
        }

        // 연결 리스트 생성
        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        // 짧은 간선부터 정렬
        Arrays.sort(lines, (o1, o2) -> {
            return (int) ((o1.dist - o2.dist) * 1000);
        });

        // 탐색
        double cost = 0;
        int cnt = 0;
        for (int i = 0; i < n * (n - 1) / 2; i++) {
            if (bfs(lines[i].s1, lines[i].s2)) {
                cost += lines[i].dist;
                cnt++;
                lists[lines[i].s1].add(lines[i].s2);
                lists[lines[i].s2].add(lines[i].s1);
            }
            if (cnt == n - 1) {
                break;
            }
        }

        System.out.println(cost);
    }

    static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    static boolean bfs(int start, int target) { // 연결되지 않았으면 true
        boolean[] visited = new boolean[n];
        visited[start] = true;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (int next : lists[now]) {
                if (next == target) {
                    return false;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    deque.addLast(next);
                }
            }
        }

        return true;
    }
}

class Line {
    double dist;
    int s1, s2;

    public Line(double dist, int s1, int s2) {
        this.dist = dist;
        this.s1 = s1;
        this.s2 = s2;
    }
}