import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] segTree;
    static int startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 세그먼트 트리 생성
        int height = 0;
        while ((1 << height) < n) {
            height++;
        }

        segTree = new long[1 << (height + 1)];
        startIdx = 1 << height;

        st = new StringTokenizer(br.readLine());
        for (int i = startIdx; i < startIdx + n; i++) {
            segTree[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = startIdx - 1; i > 0; i--) {
            segTree[i] = segTree[i << 1] + segTree[(i << 1) + 1];
        }

        // 쿼리 실행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            sb.append(getSum(Math.min(x, y), Math.max(x, y))).append("\n");
            changeVal(a, b);
        }

        System.out.println(sb);
    }

    static long getSum(int x, int y) {
        long sum = 0;
        int start = x + startIdx;
        int end = y + startIdx;
        while (start <= end) {
            if ((start & 1) == 1) {
                sum += segTree[start];
                start++;
            }
            if ((end & 1) == 0) {
                sum += segTree[end];
                end--;
            }
            start >>= 1;
            end >>= 1;
        }
        return sum;
    }

    static void changeVal(int idx, int val) {
        idx += startIdx;
        segTree[idx] = val;
        idx >>= 1;
        while (idx > 0) {
            segTree[idx] = segTree[idx << 1] + segTree[(idx << 1) + 1];
            idx >>= 1;
        }
    }
}