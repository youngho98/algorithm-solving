import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dequeA = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dequeA.addLast(Integer.parseInt(st.nextToken()));
        }

        Deque<Integer> dequeB = new ArrayDeque<>();
        int cnt = 1;
        while (!dequeA.isEmpty()) {
            if (dequeA.peekFirst() == cnt) {
                dequeA.pollFirst();
                cnt++;
            } else if (!dequeB.isEmpty() && dequeB.peekLast() == cnt) {
                dequeB.pollLast();
                cnt++;
            } else {
                dequeB.addLast(dequeA.pollFirst());
            }
        }

        while (!dequeB.isEmpty() && dequeB.peekLast() == cnt) {
            dequeB.pollLast();
            cnt++;
        }

        if (dequeB.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}