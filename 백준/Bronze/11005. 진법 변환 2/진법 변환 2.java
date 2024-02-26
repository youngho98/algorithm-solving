import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        while (n >= b) {
            dq.addLast(n % b);
            n /= b;
        }
        dq.addLast(n);

        while (!dq.isEmpty()) {
            int num = dq.pollLast();
            if (num >= 10) {
                num += 55;
                System.out.print((char) num);
            } else {
                System.out.print(num);
            }
        }
    }
}