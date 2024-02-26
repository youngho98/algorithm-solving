import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(average(arr));
        System.out.println(mid(arr));
        System.out.println(frequent(arr));
        System.out.println(range(arr));
    }

    public static int average(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avr = (double) sum / arr.length;
        return (int) Math.round(avr);
    }

    public static int mid(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    public static int frequent(int[] arr) {
        int[] cnt = new int[8001];
        for (int i : arr) {
            cnt[i + 4000]++;
        }
        int max = 0;
        for (int i : cnt) {
            if (i > max) {
                max = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                list.add(i - 4000);
            }
        }
        if (list.size() == 1) {
            return list.get(0);
        } else {
            return list.get(1);
        }
    }

    public static int range(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }
}