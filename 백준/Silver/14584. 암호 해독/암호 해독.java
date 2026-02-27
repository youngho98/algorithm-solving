import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // 알파벳을 순서만 기록
        int[] ord = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ord[i] = chars[i] - 'a';
        }

        // 암호문 해독
        for (int i = 0; i < 26; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append((char) (((ord[j] + i) % 26) + 'a'));
            }
            for (String word : words) {
                if (sb.toString().contains(word)) {
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}
