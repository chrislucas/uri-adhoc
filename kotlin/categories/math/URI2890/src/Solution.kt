import kotlin.math.round

/**
 * https://www.urionlinejudge.com.br/judge/en/problems/view/2890
 * DONE
 * */

const val M = 1000007L


fun multiplyMod(a: Long, b: Long, m: Long) = ((a%m)*(b%m))%m

fun sumMod(a: Long, b: Long, m: Long) = ((a%m)+(b%m))%m

fun sExp(b: Long, e: Long) : Long {
    return when (e) {
        0L -> 1
        1L -> b
        else  -> {
            var b = b
            var e = e
            var acc = 1L
            while (e > 0) {
                if ( (e and 1) == 1L) {
                    acc *= b
                }
                b *= b
                e = e shr 1
            }
            acc
        }
    }
}


fun coloringTetrahedron(n: Long) = sumMod(round(11.0/12.0*sExp(n, 2)).toLong(), round(1.0/12.0*sExp(n, 4)).toLong(), M)

fun main(args: Array<String>) {

    while (true) {
        val colors = readLine()?.toLong()
        if (colors != null && colors == 0L)
            break
        else if (colors != null)
            println(coloringTetrahedron(colors))
        else
            break
    }
}