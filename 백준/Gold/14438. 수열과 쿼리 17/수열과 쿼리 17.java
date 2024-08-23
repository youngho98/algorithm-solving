import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] tree;
    static int startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 세그먼트 트리 높이 구하기
        int n = Integer.parseInt(br.readLine());
        int height = 0;
        while ((1 << height) < n) {
            height++;
        }

        // 세그먼트 트리 값 입력
        tree = new int[1 << (height + 1)];
        startIdx = 1 << height;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = startIdx; i < startIdx + n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        // 세그먼트 트리 완성
        for (int i = startIdx - 1; i > 0; i--) {
            tree[i] = Math.min(tree[i << 1], tree[(i << 1) + 1]);
        }

        // 쿼리 실행
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                changeVal(idx, val);
            } else {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                sb.append(findMin(start, end)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void changeVal(int idx, int val) {
        idx += startIdx - 1;
        tree[idx] = val;
        idx >>= 1;
        while (idx > 0) {
            tree[idx] = Math.min(tree[idx << 1], tree[(idx << 1) + 1]);
            idx >>= 1;
        }
    }

    static int findMin(int start, int end) {
        start += startIdx - 1;
        end += startIdx - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if ((start & 1) == 1) {
                min = Math.min(min, tree[start]);
                start += 1;
            }
            if ((end & 1) == 0) {
                min = Math.min(min, tree[end]);
                end -= 1;
            }
            start >>= 1;
            end >>= 1;
        }
        return min;
    }
}