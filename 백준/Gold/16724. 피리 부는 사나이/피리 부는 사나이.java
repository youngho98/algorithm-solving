import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static int[][] visited;
    static int n, m, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    if (move(i, j)) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    static boolean move(int x, int y) {
        check++;
        visited[x][y] = check;

        while (true) {
            if (map[x][y] == 'U') {
                x--;
            } else if (map[x][y] == 'D') {
                x++;
            } else if (map[x][y] == 'L') {
                y--;
            } else if (map[x][y] == 'R') {
                y++;
            }
            if (visited[x][y] > 0 && visited[x][y] < check) {
                return false;
            }
            if (visited[x][y] == check) {
                break;
            }
            visited[x][y] = check;
        }
        return true;
    }
}