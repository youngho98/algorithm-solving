import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 6;
        int cnt = 1;
        while (n > 1) {
            n -= i;
            i += 6;
            cnt++;
        }
        System.out.println(cnt);
    }
}