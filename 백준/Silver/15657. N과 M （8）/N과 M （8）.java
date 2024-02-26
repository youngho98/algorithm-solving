import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[] arr;
    public static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(arr);
        recur(m);
    }
    public static void recur(int m) {
        if (m == 0) {
            for (int num : deque) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int num : arr) {
            if (deque.isEmpty() || num >= deque.peekLast()) {
                deque.addLast(num);
                recur(m - 1);
                deque.pollLast();
            }
        }
    }
}