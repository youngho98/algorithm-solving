import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int m, n;
    static ArrayList<Integer> listX = new ArrayList<>();
    static ArrayList<Integer> listY = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st2.nextToken());
                if (graph[i][j] == 1) {
                    listX.add(i);
                    listY.add(j);
                }
            }
        }

        bfs();

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                if (graph[i][j] > max) {
                    max = graph[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }

    static void bfs() {
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Deque<Integer> dequeX = new ArrayDeque<>();
        Deque<Integer> dequeY = new ArrayDeque<>();
        for (Integer a : listX) {
            dequeX.addLast(a);
        }
        for (Integer b : listY) {
            dequeY.addLast(b);
        }
        while (!dequeX.isEmpty()) {
            int x = dequeX.pollFirst();
            int y = dequeY.pollFirst();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                if (0 <= x + dx[i] && x + dx[i] < n && 0 <= y + dy[i] && y + dy[i] < m) {
                    if (visited[x + dx[i]][y + dy[i]] || graph[x + dx[i]][y + dy[i]] != 0) {
                        continue;
                    }
                    graph[x + dx[i]][y + dy[i]] = graph[x][y] + 1;
                    visited[x + dx[i]][y + dy[i]] = true;
                    dequeX.addLast(x + dx[i]);
                    dequeY.addLast(y + dy[i]);
                }
            }
        }
    }
}