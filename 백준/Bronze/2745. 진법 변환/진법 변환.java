import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        char[] chars = n.toCharArray();
        int[] nums = new int[chars.length];
        for (int i = 0; i < nums.length; i++) {
            if ('0' <= chars[i] && chars[i] <= '9') {
                nums[i] = chars[i] - 48;
            } else if ('A' <= chars[i] && chars[i] <= 'Z') {
                nums[i] = chars[i] - 55;
            }
        }

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            if (i != nums.length - 1) {
                num *= b;
            }
        }
        System.out.println(num);
    }
}