fun main() {
    val n = readln().toInt()
    val graph = Array(2 * n - 1){ BooleanArray(4 * n - 3) }
    val lastN = n - 1
    val lastX = 2 * n - 2
    val lastY = 4 * n - 4
    for (i in 0..lastN) {
        graph[0][i] = true
        graph[lastX][i] = true
        graph[0][lastY - i] = true
        graph[lastX][lastY - i] = true
        graph[i][i] = true
        graph[lastX - i][i] = true
        graph[i][lastY - i] = true
        graph[lastX - i][lastY - i] = true
        graph[i][i + lastN] = true
        graph[lastX - i][i + lastN] = true
        graph[i][lastY - i - lastN] = true
        graph[lastX - i][lastY - i - lastN] = true
    }

    val sb = StringBuilder()
    for (i in 0..lastX) {
        val str = StringBuilder()
        for (j in 0..lastY) {
            str.append(if(graph[i][j]) "*" else " ")
        }
        sb.append(str.toString().trimEnd()).append("\n")
    }
    println(sb)
}
