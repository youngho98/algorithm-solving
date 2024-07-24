import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] maze;
    static boolean[][] visited;
    static boolean[][] escape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m];
        escape = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean dfs(int x, int y) {
        if (!inMap(x, y)) {
            return true;
        }
        if (!visited[x][y]) {
            visited[x][y] = true;
            if (maze[x][y] == 'U') {
                escape[x][y] = dfs(x - 1, y);
            } else if (maze[x][y] == 'R') {
                escape[x][y] = dfs(x, y + 1);
            } else if (maze[x][y] == 'D') {
                escape[x][y] = dfs(x + 1, y);
            } else {
                escape[x][y] = dfs(x, y - 1);
            }
        }
        return escape[x][y];
    }

    static boolean inMap(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}