class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (i * (i + 1) / 2 > n) break;
            if ((i & 1) == 1 && n % 1 == 0) answer++;
            else if ((i & 1) == 0 && n % 1 == 0.5) answer++;
        }
        System.out.println(3.5 % 1);
        return answer;
    }
}