import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> listA = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            listA.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> listB = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            listB.add(Integer.parseInt(st2.nextToken()));
        }
        // 사전 순 최대 공통 부분 수열
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 100;
        while (i > 0) {
            if (listA.contains(i) && listB.contains(i)) {
                ans.add(i);
                Iterator<Integer> it = listA.iterator();
                while (it.hasNext() && it.next() != i) {
                    it.remove();
                }
                it.remove();
                Iterator<Integer> it2 = listB.iterator();
                while (it2.hasNext() && it2.next() != i) {
                    it2.remove();
                }
                it2.remove();
            } else {
                i--;
            }
        }
        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int a : ans) {
                System.out.print(a + " ");
            }
        }
    }
}