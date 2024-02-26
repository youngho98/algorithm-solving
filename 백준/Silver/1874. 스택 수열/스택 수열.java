import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int cnt = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            // cnt <= num 일 때
            while (cnt <= num) {
                sb.append("+\n");
                deque.addLast(cnt++);
            }
            // deque이 비었는지 확인
            if (deque.isEmpty()) {
                break;
            }
            // cnt > num 일 때
            if (num == deque.pollLast()) {
                sb.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}