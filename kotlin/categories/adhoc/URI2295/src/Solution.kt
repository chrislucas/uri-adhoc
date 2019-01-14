/**
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2295
 * */

fun main(args: Array<String>) {
    val values = readLine()?.split(" ")?.map{ it.toDouble() }?.toDoubleArray()
    if (values != null)
        println(if (values[2]/values[0] > values[3]/values[1]) "A" else "G")
}