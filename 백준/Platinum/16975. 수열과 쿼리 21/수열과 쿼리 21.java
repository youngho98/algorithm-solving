import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int startIdx;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 트리 사이즈 구하고 생성
        int n = Integer.parseInt(br.readLine());
        int height = 0;
        while ((1 << height) < n) {
            height++;
        }
        tree = new long[1 << (height + 1)];

        // 트리에 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        startIdx = 1 << height;
        for (int i = startIdx; i < startIdx + n; i++) {
            tree[i] = Long.parseLong(st.nextToken());
        }

        // 쿼리 수행
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(find(Integer.parseInt(st.nextToken()))).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void add(int start, int end, int val) {
        start += startIdx - 1;
        end += startIdx - 1;

        while (start <= end) {
            if ((start & 1) == 1) {
                tree[start] += val;
                start++;
            }
            if ((end & 1) == 0) {
                tree[end] += val;
                end--;
            }
            start >>= 1;
            end >>= 1;
        }
    }

    static long find(int idx) {
        idx += startIdx - 1;

        long sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx >>= 1;
        }

        return sum;
    }
}