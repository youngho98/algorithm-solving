import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 1;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ') {
                cnt++;
            }
        }
        if (s.equals(" ")) {
            cnt = 0;
        }
        System.out.println(cnt);
    }
}