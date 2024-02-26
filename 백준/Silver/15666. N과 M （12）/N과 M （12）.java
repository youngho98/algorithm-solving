import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        Collections.sort(list);
        seq(m);
    }
    public static void seq(int m) {
        if (m == 0) {
            for (int num : deque) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int num : list) {
            if (deque.isEmpty() || deque.peekLast() <= num) {
                deque.addLast(num);
                seq(m - 1);
                deque.pollLast();
            }
        }
    }
}
