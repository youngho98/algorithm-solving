import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;
        boolean exist = false;
        for (int i = 1; i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            cnt++;
            if (cnt == k) {
                System.out.println(i);
                exist = true;
                break;
            }
        }
        if (!exist) {
            System.out.println(0);
        }
    }
}