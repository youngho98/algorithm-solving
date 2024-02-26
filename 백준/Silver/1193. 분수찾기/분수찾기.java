import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int i = 1;
        int cnt = 1;
        while (x > cnt) {
            i++;
            cnt += i;
        }
        if (i % 2 == 0) {
            System.out.println((i - (cnt - x)) + "/" + (1 + (cnt - x)));
        } else {
            System.out.println((1 + (cnt - x)) + "/" + (i - (cnt - x)));
        }
    }
}