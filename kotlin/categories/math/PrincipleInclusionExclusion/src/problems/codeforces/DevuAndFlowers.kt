package problems.codeforces

const val m = 1000000007


fun readInts() =  readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray()

fun nCr(n: Long, p: Long) : Long {
    var acc = 1L
    // C(n, p) = C(n, n-p)
    val p = if (p > n - p) n - p else p
    // n! / (n-p)! * p!
    // n * n-1 ... n-p+1 / p * p-1 * ... * 1
    // n/p + n-1/p-1  + ... n-p+1/1
    for (i in 0 until p) {
        acc *= (n-i)
        acc /= (i+1)
    }
    return acc
}


fun multMod(a: Long, b: Long, m: Long) = ((a%m)*(b%m))%m

fun expMod(b: Long, e: Long, m: Long): Long {
    var acc = 1L
    var e = e
    var b = b
    while (e>0) {
        if ((e and 1) == 1L) {
            acc = multMod(acc, b, m)
        }
        b = multMod(b, b, m)
        e = e shr 1
    }
    return acc
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

fun count(boxOfFlowers: Array<Int>, target: Int) : Int {
    var odd = 0
    var even = 0
    val limit = boxOfFlowers.size
    for (i in 1 until (1 shl limit)) {
        var flowers = 0
        for (j in 0 until limit) {
            if (i and (1 shr j) > 0) {
                flowers += boxOfFlowers[i]
            }
        }
        /**
         * A quantidade de flores nas caixas escolhidas ultrapassa
         * o valor que queremos atingir
         * */
        if (flowers > target)
            continue
    }
    return odd - even
}

fun main(args: Array<String>) {

    print(nCr(23, 7))

    val boxesAndFlowers = readInts()
    if (boxesAndFlowers != null) {
        val qBoxes = boxesAndFlowers[0]
        val qFlower = boxesAndFlowers[1]
        val flowets =  readInts()
        if (flowets != null)
            println(count(flowets, qFlower))
    }
}