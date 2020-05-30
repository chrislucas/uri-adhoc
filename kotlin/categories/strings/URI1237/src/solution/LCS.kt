package solution


fun IntRange.length() = last - first

object LCS {

    @JvmStatic
    fun naiveLcs(strA: String, strB: String): Pair<IntRange, IntRange> {
        var pair = Pair(0..0, 0..0)
        for (i in strA.indices) {
            for (j in i until strA.length) {
                for (k in j until strB.length) {
                    if (strA.substring(i, k - j + i + 1) == strB.substring(j, k + 1)) {
                        val current = Pair(i..k - j + i, j..k)
                        if (current.first.length() >= pair.first.length())
                            pair = current
                    } else {
                        break
                    }
                }
            }
        }
        return pair
    }
}


fun testLcs() {
    val data = arrayOf(
        "zxabcdezy" to "yzabcdezx"
        , "GeeksforGeeks" to "GeeksQuiz"
        , "abcdxyz" to "xyzabcd"
    )
    data.forEach { pair ->
        pair.also {
            val rs = LCS.naiveLcs(it.first, it.second)
            val ms = rs.run {
                val diff = this.first.length()
                "Maior intervalo $diff, Range: $this, ${pair.first.substring(this.first)}"
            }
            println(ms)
        }
    }
}


fun main() {
    testLcs()
}