import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while ((str = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            char[] s = st.nextToken().toCharArray();
            char[] t = st.nextToken().toCharArray();

            int si = 0;
            int ti = 0;
            while (si < s.length && ti < t.length) {
                if (s[si] == t[ti]) {
                    si++;
                }
                ti++;
            }

            if (si == s.length) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }

        System.out.println(sb);
    }
}
