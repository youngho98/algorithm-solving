import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> selfNum = new HashSet<>();
        for (int i = 1; i <= 10000; i++) {
            selfNum.add(i);
        }
        for (int i = 1; i <= 10000; i++) {
            int num, sum;
            sum = num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            selfNum.remove(sum);
        }
        for (Integer num : selfNum) {
            System.out.println(num);
        }
    }
}