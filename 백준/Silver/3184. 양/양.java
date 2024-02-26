import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static int sheepTotal = 0;
    static int wolfTotal = 0;

    public static void main(String[] args) throws IOException {
        // 그래프 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        graph = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        // bfs 탐색
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (graph[i][j] == 'a' || graph[i][j] == '#') {
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(sheepTotal + " " + wolfTotal);
    }

    static void bfs(int a, int b) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int sheep = 0;
        int wolf = 0;

        if (graph[a][b] == 'o') {
            sheep++;
        } else if (graph[a][b] == 'v') {
            wolf++;
        }
        graph[a][b] = 'a';

        Deque<Location> deque = new ArrayDeque<>();
        deque.addLast(new Location(a, b));
        while (!deque.isEmpty()) {
            Location node = deque.pollFirst();
            int x = node.x;
            int y = node.y;
            for (int i = 0; i < 4; i++) {
                if (x + dx[i] < 0 || x + dx[i] >= graph.length || y + dy[i] < 0 || y + dy[i] >= graph[0].length) {
                    continue;
                }
                if (graph[x + dx[i]][y + dy[i]] == 'a' || graph[x + dx[i]][y + dy[i]] == '#') {
                    continue;
                }
                if (graph[x + dx[i]][y + dy[i]] == 'o') {
                    sheep++;
                } else if (graph[x + dx[i]][y + dy[i]] == 'v') {
                    wolf++;
                }
                graph[x + dx[i]][y + dy[i]] = 'a';
                deque.addLast(new Location(x + dx[i], y + dy[i]));
            }
        }
        if (sheep > wolf) {
            sheepTotal += sheep;
        } else {
            wolfTotal += wolf;
        }
    }
}

class Location {
    int x, y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}