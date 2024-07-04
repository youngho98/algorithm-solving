import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null) {
            list.add(str);
        }

        list.sort((o1, o2) -> {
            String ab = new StringBuilder().append(o1).append(o2).toString();
            String ba = new StringBuilder().append(o2).append(o1).toString();
            return ba.compareTo(ab);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}