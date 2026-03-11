import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val map = Array(n, { BooleanArray(n) })
    for (i in 0..n - 1) {
        val st = StringTokenizer(br.readLine())
        for (j in 0..n - 1) {
            map[i][j] = st.nextToken().toInt() == 1
        }
    }

    val dp = Array(n + 1, { Array(n + 1, { IntArray(3) })})
    dp[1][2][0] = 1
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == 1 && (j == 1 || j == 2)) continue
            if (map[i - 1][j - 1]) continue
            for (k in 0..2) {
                if (k == 1 && (i == 1 || j == 1)) continue
                if (k == 1 && (map[i - 2][j - 1] || map[i - 1][j - 2])) continue
                dp[i][j][k] = when (k) {
                    0 -> dp[i][j - 1][0] + dp[i][j - 1][1]
                    1 -> dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2]
                    2 -> dp[i - 1][j][1] + dp[i - 1][j][2]
                    else -> 0
                }
            }
        }
    }

    println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2])
}