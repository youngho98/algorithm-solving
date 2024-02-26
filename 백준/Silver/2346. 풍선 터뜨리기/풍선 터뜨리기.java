import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] value = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        while (!deque.isEmpty()) {
            int num = deque.pollFirst();
            System.out.print(num + " ");
            rotate(value[num]);
        }
    }

    static void rotate(int n) {
        if (deque.isEmpty()) {
            return;
        }
        if (n > 0) {
            rotateClock(n - 1);
        } else {
            rotateReverse(-n);
        }
    }

    static void rotateClock(int n) {
        for (int i = 0; i < n; i++) {
            deque.addLast(deque.pollFirst());
        }
    }

    static void rotateReverse(int n) {
        for (int i = 0; i < n; i++) {
            deque.addFirst(deque.pollLast());
        }
    }
}