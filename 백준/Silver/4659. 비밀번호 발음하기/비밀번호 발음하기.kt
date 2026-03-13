import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val str = br.readLine()
        if (str == "end") break
        if (check(str)) sb.append("<$str> is acceptable.\n")
        else sb.append("<$str> is not acceptable.\n")
    }

    println(sb)
}

fun check(str: String): Boolean {
    var hasVowel = false
    var vowel = 0
    var consonant = 0
    var prev = '.'
    for (c in str) {
        when (c) {
            'a', 'e', 'i', 'o', 'u' -> {
                hasVowel = true
                vowel++
                consonant = 0
            }
            else -> {
                consonant++
                vowel = 0
            }
        }
        if (vowel >= 3 || consonant >= 3) return false
        if (prev == c && c != 'e' && c != 'o') return false
        prev = c
    }
    return hasVowel
}