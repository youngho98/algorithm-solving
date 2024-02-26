import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] meeting = new int[n][2];
        for (int i = 0; i < n; i++) {
            meeting[i][0] = sc.nextInt();
            meeting[i][1] = sc.nextInt();
        }
        Arrays.sort(meeting, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);

        int now = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (meeting[i][0] >= now) {
                cnt++;
                now = meeting[i][1];
            }
        }
        System.out.println(cnt);
    }
}