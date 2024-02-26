import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] distance;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        // bfs로 distance 채우기
        distance = new int[n][n];
        visited = new boolean[n][n];
        visited[x][y] = true;
        bfs(x, y);


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            bw.write(distance[a][b] + " ");
        }
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        Deque<Point> deque = new ArrayDeque<>();
        deque.addLast(new Point(x, y, 0));
        while (!deque.isEmpty()) {
            Point now = deque.pollFirst();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (inMap(nx, ny) && !visited[nx][ny]) {
                    distance[nx][ny] = now.dist + 1;
                    visited[nx][ny] = true;
                    deque.addLast(new Point(nx, ny, distance[nx][ny]));
                }
            }
        }
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}

class Point {
    int x, y, dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
