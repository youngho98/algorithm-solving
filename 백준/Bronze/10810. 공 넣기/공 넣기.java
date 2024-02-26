import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] basket = new int[n + 1];
        for (int l = 0; l < m; l++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st2.nextToken());
            int j = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());
            for (int o = i; o <= j; o++) {
                basket[o] = k;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}