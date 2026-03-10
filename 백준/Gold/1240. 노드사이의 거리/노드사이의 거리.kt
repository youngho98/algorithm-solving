import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private class Node(val num: Int, val dist: Int)

private var n = 0
private lateinit var lists: Array<MutableList<Node>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    var st = StringTokenizer(br.readLine())
    n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    lists = Array(n) { mutableListOf() }
    for (i in 1..n - 1) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        val d = st.nextToken().toInt()
        lists[a].add(Node(b, d))
        lists[b].add(Node(a, d))
    }

    for (i in 1..m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt() - 1
        val b = st.nextToken().toInt() - 1
        sb.append(bfs(a, b)).append("\n")
    }

    println(sb)
}

private fun bfs(a: Int, b: Int): Int {
    val dq = ArrayDeque<Node>()
    val visited = BooleanArray(n)
    visited[a] = true
    dq.addLast(Node(a, 0))
    while (dq.isNotEmpty()) {
        val now = dq.removeFirst()
        for (next in lists[now.num]) {
            if (next.num == b) return now.dist + next.dist
            if (!visited[next.num]) {
                visited[next.num] = true
                dq.addLast(Node(next.num, now.dist + next.dist))
            }
        }
    }
    return -1
}