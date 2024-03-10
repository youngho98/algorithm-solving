import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        char[] binary = br.readLine().toCharArray();
        int idx = binary.length - 1;
        while (idx >= 2) {
            int num = binary[idx] - 48;
            num += (binary[idx - 1] - 48) << 1;
            num += (binary[idx - 2] - 48) << 2;
            deque.addFirst(num);
            idx -= 3;
        }
        if (idx == 1) {
            int num = binary[idx] - 48;
            num += (binary[idx - 1] - 48) << 1;
            deque.addFirst(num);
        } else if (idx == 0) {
            int num = binary[idx] - 48;
            deque.addFirst(num);
        }

        for (int i : deque) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}