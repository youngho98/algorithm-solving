import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        int cntL = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                if (arr[i + 1] == ')') {
                    cnt += cntL;
                    i++;
                } else {
                    cnt++;
                    cntL++;
                }
            } else {
                cntL--;
            }
        }
        System.out.println(cnt);
	}
}