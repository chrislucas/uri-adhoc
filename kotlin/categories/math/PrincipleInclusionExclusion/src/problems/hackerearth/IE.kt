package problems.hackerearth

/**
 * https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/tutorial/
 * https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/practice-problems/
 * DONE
 * */

fun gcd(p: Long, q: Long) : Long {
    var p = p
    var q = q
    while (p % q > 0) {
        val aux =  p % q
        p = q
        q = aux
    }
    return q
}


fun countSetBits(n: Int) : Int {
    var acc = 0
    var n = n
    while (n>0) {
        n = n and (n - 1)
        acc += 1
    }
    return acc
}

fun count(values: Array<Int>,  n: Long) {
    val limit = values.size
    var odd = 0L
    var even = 0L
    for (i in 1 until (1 shl limit) ) {
        var product = 1L
        for (j in 0 until limit) {
            if (i and (1 shl j) > 0)
                product *= values[j]
        }
        if (countSetBits(i) and 1 == 1)
            odd += (n / product)
        else
            even += (n / product)
    }
    val q = odd - even
    val g = gcd(q, n)
    println("${q/g} ${n/g}")
}

fun main(args: Array<String>) {
    count(arrayOf(2,3,11,13), readLine()?.toLong()?: 0)
}