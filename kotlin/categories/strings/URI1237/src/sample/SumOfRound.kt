package sample

import kotlin.math.log10
import kotlin.math.roundToInt

//http://codeforces.com/contest/1347/problem/C

fun Int.digits() = if (this < 10) 1 else log10(this * 1.0).roundToInt() + 1

fun Int.isRound(): Boolean {
    val digits = digits()
    var base = 10
    var cp = this
    while (cp > 1) {
        if (cp % base != 0) {
            return false
        }
        cp /= 10
        base *= 10
    }

    return true
}


object SumOfRound {

    fun solver() {

    }
}

fun main() {
    SumOfRound.solver()
}