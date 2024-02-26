import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(br.readLine());
        int hh = min / 60;
        int mm = min % 60;
        h += hh;
        m += mm;
        while (m >= 60) {
            m -= 60;
            h++;
        }
        while (h >= 24) {
            h -= 24;
        }
        System.out.println(h + " " + m);
    }
}