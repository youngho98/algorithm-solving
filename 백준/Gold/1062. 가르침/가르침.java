import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<boolean[]> list = new ArrayList<>();
    static int[] temps;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 단어 입력
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // k가 5 미만이면 불가능
        if (k < 5) {
            System.out.println(0);
            return;
        }

        // k가 5 이상일 때 알파벳 경우의 수
        temps = new int[k - 5];
        permut(0);

        // 알파벳 세트에 있는 글자로 몇 단어 읽을 수 있는지 계산
        int max = 0;
        for (boolean[] alpha : list) {
            int cnt = n;
            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    if (!alpha[word.charAt(i) - 'a']) {
                        cnt--;
                        break;
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void permut(int n) {
        if (n == k - 5) {
            boolean[] alpha = new boolean[26];
            alpha[0] = alpha[2] = alpha[8] = alpha[13] = alpha[19] = true;
            int[] alphabets = {1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 26};
            for (int i = 0; i < k - 5; i++) {
                alpha[alphabets[temps[i]]] = true;
            }
            list.add(alpha);
            return;
        }
        for (int i = 0; i < 21; i++) {
            if (n == 0 || temps[n - 1] < i) {
                temps[n] = i;
                permut(n + 1);
            }
        }
    }
}