import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = -1;
        int a = 0;
        int b = 0;
        int[][] graph = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] > max) {
                    max = graph[i][j];
                    a = i + 1;
                    b = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(a + " " + b);
    }
}