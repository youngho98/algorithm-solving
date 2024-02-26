import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        System.out.println(sum / 5);

        int num = 10;
        int cnt = 0;
        while (num < 100) {
            for (int i = 0; i < 5; i++) {
                if (arr[i] == num) {
                    cnt++;
                    arr[i] = 0;
                    if (cnt == 3) {
                        System.out.println(num);
                        return;
                    }
                }
            }
            num += 10;
        }
    }
}