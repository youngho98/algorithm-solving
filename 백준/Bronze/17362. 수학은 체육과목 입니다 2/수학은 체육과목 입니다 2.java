import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n %= 8;
        switch (n) {
            case 0:
                n = 2;
                break;
            case 6:
                n = 4;
                break;
            case 7:
                n = 3;
        }
        System.out.println(n);
    }
}