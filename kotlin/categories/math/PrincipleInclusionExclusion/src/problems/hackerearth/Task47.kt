package problems.hackerearth

/**
 * https://www.hackerearth.com/practice/math/combinatorics/inclusion-exclusion/practice-problems/algorithm/easy-one-4/
 * DONE
 * */


fun csb(n: Int) : Int {
    var acc = 0
    var n = n
    while (n>0) {
        n = n and (n - 1)
        acc += 1
    }
    return acc
}

fun st(arr: Array<Int>, m: Long) : Long {
    var odd = 0L
    var even = 0L
    val limit = arr.size
    for (i in 1 until (1 shl limit)) {
        var product = 1L
        for (j in 0 until limit) {
            if (i and (1 shl j) > 0)
                product *= arr[j]
        }
        if (csb(i) and 1 == 1)
            odd += (m / product)
        else
            even += (m / product)
    }
    return odd - even
}

fun main(args: Array<String>) {
    var cases = readLine()?.toInt()
    if (cases != null) {
        while (cases > 0) {
            val task = readLine()?.split(" ")?.map { it.toLong() }?.toTypedArray()
            val numbers =  readLine()?.split(" ")?.map { it.toInt() }?.toSet()?.toTypedArray()
            if (numbers != null && task != null) {
                println(st(numbers, task[0]))
            }
            cases--
        }
    }
}