import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[9];
        
        while (n > 0) {
            int num = n % 10;
            if (num != 9) {
                cnt[num]++;
            } else {
                cnt[6]++;
            }
            n /= 10;
        }
        
        if (cnt[6] % 2 == 0) {
            cnt[6] /= 2;
        } else {
            cnt[6] = cnt[6] / 2 + 1;
        }
        
        int max = 0;
        for (int i : cnt) {
            if (max < i) {
                max = i;
            }
        }
        
        System.out.println(max);
    }
}