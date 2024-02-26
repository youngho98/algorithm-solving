import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int target = v - a;
        int dayMove = a - b;
        if (target % dayMove == 0) {
            System.out.println(target / dayMove + 1);
        } else {
            System.out.println(target / dayMove + 2);
        }
    }
}