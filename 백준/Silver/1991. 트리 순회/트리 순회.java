import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 65;
            int a = st.nextToken().charAt(0) - 65, b = st.nextToken().charAt(0) - 65;
            tree[p][0] = a;
            tree[p][1] = b;
        }
        front(0);
        System.out.println();
        mid(0);
        System.out.println();
        rear(0);
    }
    public static void front(int n) {
        if (n < 0) return;
        System.out.print((char)(n + 65));
        front(tree[n][0]);
        front(tree[n][1]);
    }
    public static void mid(int n) {
        if (n < 0) return;
        mid(tree[n][0]);
        System.out.print((char)(n + 65));
        mid(tree[n][1]);
    }
    public static void rear(int n) {
        if (n < 0) return;
        rear(tree[n][0]);
        rear(tree[n][1]);
        System.out.print((char)(n + 65));
    }
}