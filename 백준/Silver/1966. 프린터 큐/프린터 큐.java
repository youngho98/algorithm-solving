import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                deque.addLast(Integer.parseInt(st2.nextToken()));
            }
            boolean mPrint = false;
            int cnt = 0;
            while (!mPrint) {
                if (m == 0) {
                    int print = deque.pollFirst();
                    boolean isPrint = true;
                    for (Integer doc : deque) {
                        if (print < doc) {
                            isPrint = false;
                            deque.addLast(print);
                            m = deque.size() - 1;
                            break;
                        }
                    }
                    if (isPrint) {
                        cnt++;
                        mPrint = true;
                        bw.write(cnt + "\n");
                    }
                } else {
                    int print = deque.pollFirst();
                    boolean isPrint = true;
                    for (Integer doc : deque) {
                        if (print < doc) {
                            isPrint = false;
                            deque.addLast(print);
                            m--;
                            break;
                        }
                    }
                    if (isPrint) {
                        cnt++;
                        m--;
                    }
                }
            }
        }
        bw.flush();
        bw.close();
    }
}