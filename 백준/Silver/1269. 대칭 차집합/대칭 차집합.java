import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            setA.add(Integer.parseInt(st1.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            setB.add(Integer.parseInt(st2.nextToken()));
        }

        int a = setA.size();
        int b = setB.size();
        setA.retainAll(setB);
        int c = setA.size();
        System.out.println(a + b - c * 2);
    }
}