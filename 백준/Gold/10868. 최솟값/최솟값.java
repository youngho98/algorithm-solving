import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] segTree;
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

        segTree = new int[1 << (height + 1)];
        startIdx = 1 << height;

        for (int i = startIdx; i < startIdx + n; i++) {
            segTree[i] = Integer.parseInt(br.readLine());
        }

        for (int i = startIdx - 1; i > 0; i--) {
            segTree[i] = Math.min(segTree[i << 1], segTree[(i << 1) + 1]);
        }

        // 쿼리 실행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(findMin(start, end)).append("\n");
        }

        System.out.println(sb);
    }

    static int findMin(int start, int end) {
        start += startIdx - 1;
        end += startIdx - 1;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            if ((start & 1) == 1) {
                min = Math.min(min, segTree[start]);
                start += 1;
            }
            if ((end & 1) == 0) {
                min = Math.min(min, segTree[end]);
                end -= 1;
            }
            start >>= 1;
            end >>= 1;
        }
        return min;
    }
}