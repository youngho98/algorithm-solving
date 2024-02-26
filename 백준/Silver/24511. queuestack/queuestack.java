import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] qs = new int[n];
        for (int i = 0; i < n; i++) {
            qs[i] = Integer.parseInt(st1.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st2.nextToken());
            if (qs[i] == 0) {
                deque.addLast(num);
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            deque.addFirst(Integer.parseInt(st3.nextToken()));
            bw.write(deque.pollLast() + " ");
        }

        bw.flush();
        bw.close();
    }
}