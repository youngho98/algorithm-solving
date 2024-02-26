import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] chars = str.toCharArray();
            int score = 0;
            int point = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'O') {
                    score += ++point;
                } else {
                    point = 0;
                }
            }
            System.out.println(score);
        }
    }
}