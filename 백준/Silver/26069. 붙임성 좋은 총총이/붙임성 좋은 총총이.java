import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if (set.contains(a)) {
                set.add(b);
            } else if (set.contains(b)) {
                set.add(a);
            }
        }
        System.out.println(set.size());
    }
}