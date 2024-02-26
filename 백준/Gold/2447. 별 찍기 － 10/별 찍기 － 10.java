import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];

        int num = 0;
        while (n > 1) {
            n /= 3;
            num++;
        }

        star(num, 0, 0);

        for (int i = 0; i < Math.pow(3, num); i++) {
            for (int j = 0; j < Math.pow(3, num); j++) {
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
            graph[a][b] = true;
            return;
        }
        int d = (int) Math.pow(3, n - 1);
        star(n - 1, a, b);
        star(n - 1, a, b + d);
        star(n - 1, a, b + d * 2);
        star(n - 1, a + d, b);
        star(n - 1, a + d, b + d * 2);
        star(n - 1, a + d * 2, b);
        star(n - 1, a + d * 2, b + d);
        star(n - 1, a + d * 2, b + d * 2);
    }
}