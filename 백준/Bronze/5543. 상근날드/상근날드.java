import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        int hamburger = 2000;
        int drink = 2000;
        hamburger = Math.min(hamburger, a);
        hamburger = Math.min(hamburger, b);
        hamburger = Math.min(hamburger, c);
        drink = Math.min(drink, d);
        drink = Math.min(drink, e);

        System.out.println(hamburger + drink - 50);
    }
}