import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;

        int[][] medals = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken()) - 1;
            medals[country][0] = Integer.parseInt(st.nextToken()); // 금메달
            medals[country][1] = Integer.parseInt(st.nextToken()); // 은메달
            medals[country][2] = Integer.parseInt(st.nextToken()); // 동메달
        }

        // 탐색
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i == k) {
                continue;
            }
            if (medals[i][0] > medals[k][0]) {
                rank++;
            } else if (medals[i][0] == medals[k][0]) {
                if (medals[i][1] > medals[k][1]) {
                    rank++;
                } else if (medals[i][1] == medals[k][1]) {
                    if (medals[i][2] > medals[k][2]) {
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }
}
