import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int size = (int) Math.pow(5, n);
        graph = new boolean[size][size];

        star(n, 0, 0);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        int d = (int) Math.pow(5, n - 1);
        star(n - 1, a , b + 2*d);
        star(n - 1, a + d, b + 2*d);
        for (int i = 0; i < 5; i++) {
            star(n - 1, a + 2*d, b + i*d);
        }
        for (int i = 1; i < 4; i++) {
            star(n - 1, a + 3*d, b + i*d);
        }
        star(n - 1, a + 4*d, b + d);
        star(n - 1, a + 4*d, b + 3*d);
    }
}