import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        boolean check = true;
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}