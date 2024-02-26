import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            System.out.println(triangle(a, b, c));
        }
    }

    public static String triangle(int a, int b, int c) {
        if (a >= b) {
            if (a >= c) {
                if (a >= b + c) {
                    return "Invalid";
                }
            } else {
                if (c >= a + b) {
                    return "Invalid";
                }
            }
        } else {
            if (b >= c) {
                if (b >= a + c) {
                    return "Invalid";
                }
            } else {
                if (c >= a + b) {
                    return "Invalid";
                }
            }
        }
        if (a != b && b != c && c != a) {
            return "Scalene";
        } else if (a == b && b == c) {
            return "Equilateral";
        } else {
            return "Isosceles";
        }
    }
}