import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(pizza(n));
    }

    static int pizza(int n) {
        if (n == 1) {
            return 0;
        }
        return pizza(n / 2) + pizza(n - n / 2) + (n / 2) * (n - n / 2);
    }
}