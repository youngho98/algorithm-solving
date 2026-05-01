class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var idxA = a - 1
        var idxB = b - 1
        var round = 1
        while (true) {
            idxA /= 2
            idxB /= 2
            if (idxA == idxB) return round
            round++
        }
    }
}