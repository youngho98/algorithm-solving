import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sugar3 = 0, sugar5 = n / 5;
        boolean impossible = true;
        for (int i = 0; i < 3; i++) {
            if ((n - sugar5 * 5) % 3 == 0) {
                sugar3 = (n - sugar5 * 5) / 3;
                impossible = false;
                break;
            }
            if (sugar5 > 0) {
                sugar5--;
            }
        }
        if (impossible) {
            System.out.println(-1);
        } else {
            System.out.println(sugar5 + sugar3);;
        }
    }
}