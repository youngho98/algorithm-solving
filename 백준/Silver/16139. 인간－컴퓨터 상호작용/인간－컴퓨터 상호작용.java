import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int[][] prefix = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (c - 'a' == j) {
                    prefix[j][i + 1] = prefix[j][i] + 1;
                } else {
                    prefix[j][i + 1] = prefix[j][i];
                }
            }
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(prefix[a][c + 1] - prefix[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}