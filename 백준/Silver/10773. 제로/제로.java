import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                dq.pollLast();
            } else {
                dq.addLast(n);
            }
        }
        int sum = 0;
        for (int i : dq) sum += i;
        System.out.println(sum);
    }
}