import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            cantor(n);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void cantor(int n) throws IOException {
        if (n == 0) {
            bw.write("-");
            return;
        }
        cantor(n - 1);
        for (int i = 0; i < Math.pow(3, n - 1); i++) {
            bw.write(" ");
        }
        cantor(n - 1);
    }
}