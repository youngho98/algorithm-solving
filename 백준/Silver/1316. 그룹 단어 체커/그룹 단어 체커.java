import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (checker(s)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean checker(String s) {
        boolean[] check = new boolean[26];
        char[] chars = s.toCharArray();
        check[chars[0] - 97] = true;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                if (check[chars[i] - 97]) {
                    return false;
                } else {
                    check[chars[i] - 97] = true;
                }
            }
        }
        return true;
    }
}