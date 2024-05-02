import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] chess = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (((i + j) & 1) == 0 && chess[i][j] == 'F') {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}