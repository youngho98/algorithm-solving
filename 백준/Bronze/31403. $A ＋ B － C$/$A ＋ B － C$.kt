import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a: String = br.readLine()
    val b: String = br.readLine()
    val C: Int = Integer.parseInt(br.readLine())
    val AB: Int = Integer.parseInt(a + b)
    val A: Int = Integer.parseInt(a)
    val B: Int = Integer.parseInt(b)
    println(A + B - C)
    println(AB - C)
}