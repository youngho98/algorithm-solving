import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] chess;

    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chess = new char[n][m];
        for (int i = 0; i < n; i++) {
            chess[i] = br.readLine().toCharArray();
        }

        // 8 * 8로 잘랐을 때 바꿔야할 개수 세기
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                ans = Math.min(countChange(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    // (x, y) 에서 시작하는 8 * 8 체스판을 만들 때 바꿔야할 개수
    static int countChange(int x, int y) {
        // i + j 가 짝수인 칸과, 홀수인 칸으로 나누어 White, Black 개수 세기
        int evenWhite = 0;
        int oddWhite = 0;
        int evenBlack = 0;
        int oddBlack = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j & 1) == 0) {
                    if (chess[i][j] == 'W') {
                        evenWhite++;
                    } else {
                        evenBlack++;
                    }
                } else {
                    if (chess[i][j] == 'W') {
                        oddWhite++;
                    } else {
                        oddBlack++;
                    }
                }
            }
        }
        // 합이 홀수칸을 B, 짝수칸을 W로 만드는 경우와 반대의 경우 중 더 작은 값을 리턴
        return Math.min(oddWhite + evenBlack, oddBlack + evenWhite);
    }
}
