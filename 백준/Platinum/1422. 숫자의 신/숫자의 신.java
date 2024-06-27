import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[] arr = new String[k];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arr[i] = br.readLine();
            list.add(arr[i]);
        }

        Arrays.sort(arr, ((o1, o2) -> {
            if (o1.length() == o2.length()) {
                StringBuilder ab = new StringBuilder().append(o1).append(o2);
                StringBuilder ba = new StringBuilder().append(o2).append(o1);
                return ba.compareTo(ab);
            }
            return o2.length() - o1.length();
        }));

        for (int i = 0; i < n - k; i++) {
            list.add(arr[0]);
        }

        list.sort(((o1, o2) -> {
            StringBuilder ab = new StringBuilder().append(o1).append(o2);
            StringBuilder ba = new StringBuilder().append(o2).append(o1);
            return ba.compareTo(ab);
        }));

        for (String s : list) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}
