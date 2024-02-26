import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();

        int cnt = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'c' && i < chars.length - 1) {
                if (chars[i + 1] == '=' || chars[i + 1] == '-') {
                    i += 2;
                } else {
                    i++;
                }
            } else if (chars[i] == 'd') {
                if (i < chars.length - 2 && chars[i + 1] == 'z' && chars[i + 2] == '=') {
                    i += 3;
                } else if (i < chars.length - 1 && chars[i + 1] == '-') {
                    i += 2;
                } else {
                    i++;
                }
            } else if (chars[i] == 'l' || chars[i] == 'n') {
                if (i < chars.length - 1 && chars[i + 1] == 'j') {
                    i += 2;
                } else {
                    i++;
                }
            } else if (chars[i] == 's' || chars[i] == 'z') {
                if (i < chars.length - 1 && chars[i + 1] == '=') {
                    i += 2;
                } else {
                    i++;
                }
            } else {
                i++;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}