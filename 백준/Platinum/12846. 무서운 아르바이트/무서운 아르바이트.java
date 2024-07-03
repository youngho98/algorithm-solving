import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 날짜 입력
        int n = Integer.parseInt(br.readLine());

        // 급여 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] pay = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }
        pay[n] = 0;

        // 스택 활용
        long profit = 0L;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && pay[deque.peekLast()] >= pay[i]) {
                int payment = pay[deque.pollLast()];
                long day = deque.isEmpty() ? i : i - 1 - deque.peekLast();
                profit = Math.max(payment * day, profit);
            }
            deque.addLast(i);
        }

        // 정답 출력
        System.out.println(profit);
    }
}