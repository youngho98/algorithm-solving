import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x_max = -10001;
        int x_min = 10001;
        int y_max = -10001;
        int y_min = 10001;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a > x_max) {
                x_max = a;
            }
            if (a < x_min) {
                x_min = a;
            }
            if (b > y_max) {
                y_max = b;
            }
            if (b < y_min) {
                y_min = b;
            }
        }
        System.out.println((x_max - x_min) * (y_max - y_min));
    }
}