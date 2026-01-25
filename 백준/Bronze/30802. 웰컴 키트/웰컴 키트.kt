import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    val s = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val l = st.nextToken().toInt()
    val xl = st.nextToken().toInt()
    val xxl = st.nextToken().toInt()
    val xxxl = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val t = st.nextToken().toDouble()
    val p = st.nextToken().toInt()

    var tShirt = 0
    tShirt += Math.ceil(s / t).toInt()
    tShirt += Math.ceil(m / t).toInt()
    tShirt += Math.ceil(l / t).toInt()
    tShirt += Math.ceil(xl / t).toInt()
    tShirt += Math.ceil(xxl / t).toInt()
    tShirt += Math.ceil(xxxl / t).toInt()

    println(tShirt)
    println("${n / p} ${n % p}")
}