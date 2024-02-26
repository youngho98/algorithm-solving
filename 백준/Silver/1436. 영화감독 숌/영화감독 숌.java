import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int num = 1;
        while (cnt < n) {
            String numStr = Integer.toString(num);
            if (numStr.contains("666")) {
                cnt++;
            }
            num++;
        }
        System.out.println(num - 1);
    }
}