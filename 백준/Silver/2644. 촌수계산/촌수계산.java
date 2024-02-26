import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] family;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        int n = Integer.parseInt(br.readLine()); // 전체 인원 수
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st1.nextToken()); // 촌수 탐색 대상
        int b = Integer.parseInt(st1.nextToken()); // 촌수 탐색 대상

        // 인접 리스트 생성
        family = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            family[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            family[x].add(y);
            family[y].add(x);
        }

        // bfs
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = -1;
        }

        System.out.println(bfs(a, b));
    }

    static int bfs(int node1, int node2) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(node1);
        dist[node1] = 0;
        while (!deque.isEmpty()) {
            int node = deque.pollFirst();
            for (int connect : family[node]) {
                if (dist[connect] == -1) {
                    deque.addLast(connect);
                    dist[connect] = dist[node] + 1;
                }
            }
        }
        return dist[node2];
    }
}