import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            // a 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int[] cardA = new int[5];
            for (int j = 0; j < a; j++) {
                int num = Integer.parseInt(st.nextToken());
                cardA[num]++;
            }

            // b 입력
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int[] cardB = new int[5];
            for (int j = 0; j < b; j++) {
                int num = Integer.parseInt(st.nextToken());
                cardB[num]++;
            }

            // 대결 후 출력
            sb.append(battle(cardA, cardB) + "\n");
        }
        System.out.println(sb);
    }

    static String battle (int[] cardA, int[] cardB) {
        for (int i = 4; i > 0; i--) {
            if (cardA[i] > cardB[i]) {
                return "A";
            } else if (cardA[i] < cardB[i]) {
                return "B";
            }
        }
        return "D";
    }
}