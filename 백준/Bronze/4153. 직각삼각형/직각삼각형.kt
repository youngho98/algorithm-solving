import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        if (a == 0 && b == 0 && c == 0) {
            break
        }
        if (checkTriangle(a, b, c)) {
            println("right")
        } else {
            println("wrong")
        }
    }
}

fun checkTriangle(a: Int, b: Int, c: Int): Boolean {
    return when {
        a >= b && a >= c -> a * a == b * b + c * c
        b >= a && b >= c -> b * b == a * a + c * c
        else -> c * c == a * a + b * b
    }
}