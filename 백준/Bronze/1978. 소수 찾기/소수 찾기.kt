import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    var cnt = 0
    for (i in 1..n) {
        val num = st.nextToken().toInt()
        if (isPrime(num)) {
            cnt++
        }
    }

    println(cnt)
}

fun isPrime(n: Int): Boolean {
    if (n == 1) {
        return false
    }
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}