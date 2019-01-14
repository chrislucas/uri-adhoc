/**
 * https://www.urionlinejudge.com.br/judge/en/problems/view/1261
 *
 * DONE
 *
 * */

fun main(args: Array<String>) {
    var enter = readLine()?.split(" ")
    val words = enter?.get(0)?.toInt()
    val descriptions = enter?.get(1)?.toInt()
    if (words != null && descriptions != null) {
        val dict = hashMapOf<String, Long>()
        for (i in 0 until words) {
            enter = readLine()?.split(" ")
            dict[enter!![0]] = enter[1].toLong()
        }
        var i = 0
        var acc: Long = 0L
        while (i < descriptions) {
            val description = readLine()
            if (description.equals(".")) {
                println(acc)
                acc = 0L
                i++
            }
            else {
                for (word in description!!.split(" ")) {
                    if (dict.contains(word)) {
                        acc += dict[word]!!
                    }
                }
            }
        }
    }
}