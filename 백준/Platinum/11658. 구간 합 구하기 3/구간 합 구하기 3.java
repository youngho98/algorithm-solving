import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] segTree;
    static int startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 트리 생성
        int height = 0;
        while ((1 << height) < n) {
            height++;
        }

        segTree = new int[n][1 << (height + 1)];
        startIdx = 1 << height;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = startIdx; j < startIdx + n; j++) {
                segTree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = startIdx - 1; j > 0; j--) {
                segTree[i][j] = segTree[i][j << 1] + segTree[i][(j << 1) + 1];
            }
        }

        // 쿼리 실행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            // 추가
            if (st.nextToken().equals("0")) {
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                changeTree(x, y, c);
            }
            // 연산
            else {
                int x1 = Integer.parseInt(st.nextToken()) - 1;
                int y1 = Integer.parseInt(st.nextToken()) - 1;
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;
                sb.append(getSum(x1, y1, x2, y2)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void changeTree(int x, int y, int c) {
        y += startIdx;
        segTree[x][y] = c;
        y >>= 1;
        while (y > 0) {
            segTree[x][y] = segTree[x][y << 1] + segTree[x][(y << 1) + 1];
            y >>= 1;
        }
    }

    static int getSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            int start = y1 + startIdx;
            int end = y2 + startIdx;
            while (start <= end) {
                if ((start & 1) == 1) {
                    sum += segTree[i][start];
                    start++;
                }
                if ((end & 1) == 0) {
                    sum += segTree[i][end];
                    end--;
                }
                start >>= 1;
                end >>= 1;
            }
        }
        return sum;
    }
}