import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1로 채우고 도난이면 -1, 여벌 이있으면 +1
        int[] cnt = new int[n + 1];
        Arrays.fill(cnt, 1);
        cnt[0]--;
        for (int l : lost) cnt[l]--;
        for (int r : reserve) cnt[r]++;
        
        for (int i = 1; i <= n; i++) {
            System.out.print(cnt[i] + " ");
        }
        System.out.println();

        // 양 끝의 0번, n번 학생 별도처리
        if (cnt[1] == 0 && cnt[2] == 2){
            cnt[1]++;
            cnt[2]--;
        }

        if (cnt[n] == 0 && cnt[n - 1] == 2) {
            cnt[n]++;
            cnt[n-1]--;
        }

        // 2번  ~ n - 1번
        for (int i = 2; i <= n - 1; i++){
            if (cnt[i] == 0) {
                if (cnt[i - 1] == 2) {
                    cnt[i]++;
                    cnt[i - 1]--;
                } else if (cnt[i + 1] == 2) {
                    cnt[i]++;
                    cnt[i + 1]--;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(cnt[i] + " ");
        }
        System.out.println();

        // 옷있는 사람 수 출력
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] > 0) ans++;
        }
        return ans;
    }
}