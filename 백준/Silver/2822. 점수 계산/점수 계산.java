import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] score = new int[8][2];
        for (int i = 0; i < 8; i++) {
            score[i][0] = Integer.parseInt(br.readLine());
            score[i][1] = i + 1;
        }
        Arrays.sort(score, (o1, o2) -> o2[0] - o1[0]);

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sum += score[i][0];
            list.add(score[i][1]);
        }
        Collections.sort(list);

        sb.append(sum).append("\n");
        for (int i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}