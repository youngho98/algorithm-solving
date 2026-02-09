import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[1001][1001];
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            fillMap(i, x, y, dx, dy);
        }

        size = new int[n + 1];
        findSize();

        for (int i = 1; i < n + 1; i++) {
            sb.append(size[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void fillMap(int num, int x, int y, int dx, int dy) {
        for (int i = x; i < x + dx; i++) {
            for (int j = y; j < y + dy; j++) {
                map[i][j] = num;
            }
        }
    }

    static void findSize() {
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                size[map[i][j]]++;
            }
        }
    }
}
