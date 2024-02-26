import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<int[]> combList = new ArrayList<>();
    static ArrayList<Integer> temp = new ArrayList<>();
    static int n;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 인구 수 입력
        int[] population = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 리스트 생성
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int con = Integer.parseInt(st.nextToken()) - 1;
                list[i].add(con);
            }
        }

        // 조합 계산
        for (int i = 1; i <= n / 2; i++) {
            combination(n, i);
        }

        // 조합에 따른 선거구 가능여부 & 인구 차이 계산
        int minVal = Integer.MAX_VALUE;
        for (int[] ints : combList) {
            // set을 이용하여 revInts 생성
            HashSet<Integer> set = new HashSet<>();
            for (int i : ints) {
                set.add(i);
            }
            int[] revInts = new int[n - ints.length];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (!set.contains(i)) {
                    revInts[idx++] = i;
                }
            }

            // ints와 revInts로 선거구 나누기가 가능하면 인구 차이를 계산
            if (possible(ints) && possible(revInts)) {
                int intsSum = 0;
                int revIntsSum = 0;
                for (int i : ints) {
                    intsSum += population[i];
                }
                for (int i : revInts) {
                    revIntsSum += population[i];
                }
                minVal = Math.min(Math.abs(intsSum - revIntsSum), minVal);
            }
        }

        // 정답 출력
        if (minVal == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minVal);
        }
    }

    static void combination(int n, int r) {
        if (r == 0) {
            int[] arr = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                arr[i] = temp.get(i);
            }
            combList.add(arr);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) < i) {
                temp.add(i);
                combination(n, r - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    static boolean possible(int[] ints) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : ints) {
            set.add(i);
        }

        boolean[] check = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        check[ints[0]] = true;
        deque.addLast(ints[0]);

        while (!deque.isEmpty()) {
            int now = deque.pollFirst();
            for (int next : list[now]) {
                if (!check[next] && set.contains(next)) {
                    check[next] = true;
                    deque.addLast(next);
                }
            }
        }

        for (int i : ints) {
            if (!check[i]) {
                return false;
            }
        }

        return true;
    }
}