import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new boolean[n][2 * n];
        int num = n / 3;
        int k = 0;
        while (num > 1) {
            num /= 2;
            k++;
        }

        star(k, n - 1, 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n; j++) {
                if (graph[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void star(int n, int a, int b) {
        if (n == 0) {
            graph[a - 2][b + 2] = true;
            graph[a - 1][b + 1] = true;
            graph[a - 1][b + 3] = true;
            for (int i = 0; i < 5; i++) {
                graph[a][b + i] = true;
            }
            return;
        }
        int d = (int) Math.pow(2, n - 1) * 3;
        star(n - 1, a, b);
        star(n - 1, a, b + d * 2);
        star(n - 1, a - d, b + d);
    }
}