import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if (a == b && b == c) {
            System.out.println(10000 + 1000 * a);
        } else if (a == b || a == c) {
            System.out.println(1000 + 100 * a);
        } else if (b == c) {
            System.out.println(1000 + 100 * b);
        } else {
            System.out.println(100 * Math.max(Math.max(a, b), c));
        }
    }
}