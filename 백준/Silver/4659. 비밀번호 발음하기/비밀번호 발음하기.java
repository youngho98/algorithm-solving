import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }
            if (check(s)) {
                sb.append("<").append(s).append("> is acceptable.").append("\n");
            } else {
                sb.append("<").append(s).append("> is not acceptable.").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean check(String s) {
        boolean vowelCheck = false; // 모음이 하나라도 있는가?
        int con = 0; // 연속된 자음
        int vow = 0; // 연속된 모음
        char prev = '0'; // 이전 문자
        for (int i = 0; i < s.length(); i++) {
            if (vowel(s.charAt(i))) {
                vowelCheck = true;
                con = 0;
                vow++;
            } else {
                vow = 0;
                con++;
            }
            // 자음이나 모음이 연속 3개 이상이면
            if (con >= 3 || vow >= 3) {
                return false;
            }
            // 'e', 'o'가 아니고 이전 문자와 같으면
            if (prev == s.charAt(i) && prev != 'e' && prev != 'o') {
                return false;
            }
            prev = s.charAt(i);
        }
        return vowelCheck;
    }

    static boolean vowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
