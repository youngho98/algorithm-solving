import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            char[] chars = s.toCharArray();
            Deque<Integer> deque = new ArrayDeque<>();
            boolean balance = true;
            for (char c : chars) {
                if (c == '(') {
                    deque.addLast(1);
                } else if (c == '[') {
                    deque.addLast(2);
                } else if (c == ')') {
                    if (deque.isEmpty() || deque.peekLast() == 2) {
                        balance = false;
                        break;
                    } else {
                        deque.pollLast();
                    }
                } else if (c == ']') {
                    if (deque.isEmpty() || deque.peekLast() == 1) {
                        balance = false;
                        break;
                    } else {
                        deque.pollLast();
                    }
                }
            }
            if (!deque.isEmpty()) {
                balance = false;
            }
            if (balance) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}