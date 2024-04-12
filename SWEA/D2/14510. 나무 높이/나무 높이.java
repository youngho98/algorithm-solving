import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] tree = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                tree[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, tree[i]);
            }

            int[] grow = new int[n];
            for (int i = 0; i < n; i++) {
                grow[i] = max - tree[i];
            }

            int day = 0;
            while (true) {
                day++;
                boolean water = false;
                if ((day & 1) == 1) {
                    for (int i = 0; i < n; i++) {
                        if ((grow[i] & 1) == 1) {
                            grow[i]--;
                            water = true;
                            break;
                        }
                    }
                    if (!water) {
                        int cnt = 0;
                        for (int i = 0; i < n; i++) {
                            if (grow[i] > 0) {
                                cnt += grow[i];
                            }
                            if (cnt >= 4) {
                                grow[i]--;
                                break;
                            }
                        }
                        if (cnt == 0) {
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (grow[i] >= 2) {
                            grow[i] -= 2;
                            water = true;
                            break;
                        }
                    }
                    if (!water) {
                        int cnt = 0;
                        for (int i = 0; i < n; i++) {
                            if (grow[i] > 0) {
                                cnt++;
                            }
                            if (cnt > 0) {
                                break;
                            }
                        }
                        if (cnt == 0) {
                            break;
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ").append(day - 1).append("\n");
        }
        System.out.println(sb);
    }
}