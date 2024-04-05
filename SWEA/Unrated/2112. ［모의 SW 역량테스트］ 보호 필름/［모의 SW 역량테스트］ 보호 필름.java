import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int d, w, k;
	static int ans;
	static boolean[][] film;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            
            film = new boolean[d][w];
            for (int i = 0; i < d; i++) {
            	st = new StringTokenizer(br.readLine());
            	for (int j = 0; j < w; j++) {
            		if (st.nextToken().charAt(0) == '1') {
            			film[i][j] = true;
            		}
            	}
            }
            
            if (k == 1) {
            	ans = 0;
            } else {
	            ans = Integer.MAX_VALUE;
	            fill(0, 0);
            }
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    
    static void fill(int idx, int cnt) {
    	if (check()) {
    		ans = Math.min(ans, cnt);
    		return;
    	}
    	if (cnt > ans) {
    		return;
    	}
    	if (idx == d) {
    		return;
    	}
    	
    	boolean[] tmp = new boolean[w];
        for(int i=0; i<w; i++) {
            tmp[i] = film[idx][i];
        }
        
        Arrays.fill(film[idx], false);
    	fill(idx + 1, cnt + 1);
    	
    	Arrays.fill(film[idx], true);
    	fill(idx + 1, cnt + 1);
    	
    	for(int i=0; i<w; i++) {
            film[idx][i] = tmp[i];
        }
    	
    	fill(idx + 1, cnt);
    }
    
    static boolean check() {
    	for (int i = 0; i < w; i++) {
    		int cnt = 1;
    		boolean pass = false;
    		for (int j = 1; j < d; j++) {
    			if (film[j][i] == film[j - 1][i]) {
    				cnt++;
    				if (cnt == k) {
    					pass = true;
    					break;
    				}
    			} else {
    				cnt = 1;
    			}
    		}
    		if (!pass) {
    			return false;
    		}
    	}
    	return true;
    }
}