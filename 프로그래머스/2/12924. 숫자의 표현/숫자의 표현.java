// 홀수개의 합일 때는 가운데 값이 자연수여야 하고,
// 짝수개의 합일 때는 가운데 값이 x.5 여야 한다.

class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i * (i + 1) <= n * 2; i++) {
            if ((i & 1) == 1 && n % i == 0) answer++;
            else if ((i & 1) == 0 && (2 * n) % i == 0 && (2 * n / i) % 2 == 1) answer++;
        }
        return answer;
    }
}
