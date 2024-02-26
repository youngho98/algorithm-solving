import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            System.out.print(c / 25 + " ");
            c %= 25;
            System.out.print(c / 10 + " ");
            c %= 10;
            System.out.print(c / 5 + " ");
            c %= 5;
            System.out.print(c);
            System.out.println();
        }
    }
}