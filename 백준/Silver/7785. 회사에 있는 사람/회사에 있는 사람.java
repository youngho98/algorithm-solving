import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ent = st.nextToken();
            if (ent.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(Collections.reverseOrder());
        for (String s : list) {
            System.out.println(s);
        }
    }
}