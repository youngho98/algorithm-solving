import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] arr = new int[13];
        arr[1] = arr[3] = arr[5] = arr[7] = arr[8] = arr[10] = arr[12] = 31;
        arr[4] = arr[6] = arr[9] = arr[11] = 30;
        arr[2] = 28;

        int[] sum = new int[13];
        for (int i = 2; i < 13; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        int date = sum[m] + d;

        switch (date % 7) {
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
            default:
                System.out.println("SUN");
        }
    }
}