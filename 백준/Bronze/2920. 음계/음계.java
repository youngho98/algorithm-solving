import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = sc.nextInt();
        }

        if (arr[0] == 1) {
            for (int i = 1; i < 8; i++) {
                if (arr[i] != i + 1) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
        } else if (arr[0] == 8) {
            for (int i = 1; i < 8; i++) {
                if (arr[i] != 8 - i) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}