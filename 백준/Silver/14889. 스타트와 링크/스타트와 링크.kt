import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.min

private var n = 0
private var ans = Int.MAX_VALUE
lateinit var stat: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    stat = Array(n) { IntArray(n) }
    for (i in 0..<n) {
        val st = StringTokenizer(br.readLine())
        for (j in 0..<n) {
            stat[i][j] = st.nextToken().toInt()
        }
    }

    teams(0, 0, 0)

    println(ans)
}

fun teams(idx: Int, cnt: Int, value: Int) {
    if (cnt == n / 2) {
        ans = min(calculate(value), ans)
        return
    }
    if (idx == n) return

    teams(idx + 1, cnt + 1, value + 1.shl(idx))
    teams(idx + 1, cnt, value)
}

fun calculate(value: Int): Int {
    var team1 = mutableListOf<Int>()
    var team2 = mutableListOf<Int>()
    var sum1 = 0
    var sum2 = 0
    for (i in 0..<n) {
        if (value.and(1.shl(i)) != 0) team1.add(i) else team2.add(i)
    }
    for (i in 0..<n / 2) {
        for (j in i + 1..<n / 2) {
            sum1 += stat[team1[i]][team1[j]]
            sum1 += stat[team1[j]][team1[i]]
            sum2 += stat[team2[i]][team2[j]]
            sum2 += stat[team2[j]][team2[i]]
        }
    }
    return abs(sum1 - sum2)
}