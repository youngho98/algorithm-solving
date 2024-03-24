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

        queen(0);

        System.out.println(cnt);
    }

    static void queen(int x) {
        if (x == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[x] = i;
            if (check(x)) {
                queen(x + 1);
            }
        }
    }

    static boolean check(int x) {
        for (int i = 0; i < x; i++) {
            if (board[x] == board[i] || Math.abs(x - i) == Math.abs(board[x] - board[i])) {
                return false;
            }
        }
        return true;
    }
}