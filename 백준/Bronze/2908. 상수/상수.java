import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int changeA = (a.charAt(2) - 48) * 100 + (a.charAt(1) - 48) * 10 + (a.charAt(0) - 48);
        int changeB = (b.charAt(2) - 48) * 100 + (b.charAt(1) - 48) * 10 + (b.charAt(0) - 48);
        System.out.println(Math.max(changeA, changeB));
    }
}