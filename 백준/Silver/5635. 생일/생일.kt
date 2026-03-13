import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private class Student(val name: String, val birth: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val students = mutableListOf<Student>()
    for (i in 0..<n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val date = st.nextToken().toInt()
        val month = st.nextToken().toInt()
        val year = st.nextToken().toInt()
        students.add(Student(name, year * 10000 + month * 100 + date))
    }
    students.sortBy { it.birth }
    println(students[n - 1].name)
    println(students[0].name)
}