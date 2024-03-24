import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] board;
    static int n, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n];

        for (int i = 0; i < n; i++) {
            queen(0, i);
        }

        System.out.println(cnt);
    }

    static void queen(int x, int y) {
        if (canCatch(x, y)) {
            return;
        }
        if (x == n - 1) {
            cnt++;
            return;
        }
        board[x] = y;
        for (int i = 0; i < n; i++) {
            queen(x + 1, i);
        }
    }

    static boolean canCatch(int x, int y) {
        for (int i = 0; i < x; i++) {
            if (y == board[i] || Math.abs(x - i) == Math.abs(y - board[i])) {
                return true;
            }
        }
        return false;
    }
}