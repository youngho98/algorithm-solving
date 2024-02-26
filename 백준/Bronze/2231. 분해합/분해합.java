import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean cons = false;
        for (int i = 1; i < n; i++) {
            String s = String.valueOf(i);
            int sum = i;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - 48;
            }
            if (sum == n) {
                System.out.println(i);
                cons = true;
                break;
            }
        }
        if (!cons) {
            System.out.println(0);
        }
    }
}