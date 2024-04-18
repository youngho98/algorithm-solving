import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int startIdx;
    static int[][] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 트리 사이즈 구하고 생성
        int height = 0;
        while ((1 << height) < n) {
            height++;
        }
        tree = new int[1 << (height + 1)][2];

        // 트리에 값 입력
        startIdx = 1 << height;
        for (int i = startIdx; i < startIdx + n; i++) {
            int num = Integer.parseInt(br.readLine());
            tree[i][0] = tree[i][1] = num;
        }
        treeSet();

        // 최소, 최댓값 찾기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            find(a, b);
        }

        System.out.println(sb);
    }

    static void treeSet() {
        for (int i = startIdx - 1; i > 0; i--) {
            tree[i][0] = Math.min(tree[i * 2][0], tree[i * 2 + 1][0]);
            tree[i][1] = Math.max(tree[i * 2][1], tree[i * 2 + 1][1]);
        }
    }

    static void find(int start, int end) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        start += startIdx - 1;
        end += startIdx - 1;

        while (start <= end) {
            if ((start & 1) == 1) {
                min = Math.min(min, tree[start][0]);
                max = Math.max(max, tree[start][1]);
                start++;
            }
            if ((end & 1) == 0) {
                min = Math.min(min, tree[end][0]);
                max = Math.max(max, tree[end][1]);
                end--;
            }
            start >>= 1;
            end >>= 1;
        }

        sb.append(min).append(" ").append(max).append("\n");
    }
}