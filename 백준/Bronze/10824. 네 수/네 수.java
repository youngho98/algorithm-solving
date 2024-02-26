import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        String strC = Integer.toString(c);
        String strD = Integer.toString(d);
        long num1 = Long.parseLong(strA + strB);
        long num2 = Long.parseLong(strC + strD);
        System.out.println(num1 + num2);
    }
}