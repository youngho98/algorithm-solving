import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr, (o1, o2) -> {
            String ab = new StringBuilder().append(o1).append(o2).toString();
            String ba = new StringBuilder().append(o2).append(o1).toString();
            return ba.compareTo(ab);
        });

        for (String s : arr) {
            sb.append(s).append(" ");
        }

        System.out.println(sb);
    }
}