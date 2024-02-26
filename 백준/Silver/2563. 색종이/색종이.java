import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] graph = new boolean[100][100];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j < a + 10; j++) {
                for (int k = b; k < b + 10; k++) {
                    graph[j][k] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (graph[i][j]) {
                    area++;
                }
            }
        }
        System.out.println(area);
    }
}