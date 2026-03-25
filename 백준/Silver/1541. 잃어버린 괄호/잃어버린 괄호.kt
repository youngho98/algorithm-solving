fun main() {
    val input = readln()
    var ans = 0
    var num = 0
    var minus = false
    for (c in input) {
        if (c in '0'..'9') num = num * 10 + (c - '0')
        else {
            if (minus) ans -= num else ans += num
            if (c == '-') minus = true
            num = 0
        }
    }
    if (minus) ans -= num else ans += num
    println(ans)
}