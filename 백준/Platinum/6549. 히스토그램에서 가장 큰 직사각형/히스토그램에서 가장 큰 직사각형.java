import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 개수 입력
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            // 직사각형 높이 입력
            int[] rect = new int[n + 1];
            for (int i = 0; i < n; i++) {
                rect[i] = Integer.parseInt(st.nextToken());
            }
            rect[n] = 0;

            // 스택 활용
            long area = 0L;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i <= n; i++) {
                while (!deque.isEmpty() && rect[deque.peekLast()] >= rect[i]) {
                    int height = rect[deque.pollLast()];
                    long width = deque.isEmpty() ? i : i - 1 - deque.peekLast();
                    area = Math.max(height * width, area);
                }
                deque.addLast(i);
            }

            // 정답 출력
            sb.append(area).append("\n");
        }

        System.out.println(sb);
    }
}