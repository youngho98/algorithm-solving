import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Integer[] tmp = new Integer[] {Integer.parseInt(st.nextToken()), i};
            if (stack.isEmpty()) {
                stack.push(tmp);
                continue;
            }
            while (!stack.isEmpty() && stack.peek()[0] < tmp[0]) {
                ans[stack.pop()[1]] = tmp[0];
            }
            stack.push(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}
