package problems.codeforces

const val m = 1000000007


fun readInts() =  readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray()


fun countSetBits(n: Int) : Int {
    var acc = 0
    var n = n
    while (n>0) {
        n = n and (n - 1)
        acc += 1
    }
    return acc
}

fun count(flowers: Array<Int>, q: Int) : Int {
    var odd = 0
    var even = 0
    val limit = flowers.size
    for (i in 1 until (1 shl limit)) {
        var counter = 0
        for (j in 0 until limit) {
            if (i and (1 shr j) > 0) {
                counter += flowers[i]
            }
        }
    }
    return odd - even
}

fun main(args: Array<String>) {
    val boxesAndFlowers = readInts()
    if (boxesAndFlowers != null) {
        val qBoxes = boxesAndFlowers[0]
        val qFlower = boxesAndFlowers[1]
        val flowets =  readInts()
        if (flowets != null)
            println(count(flowets, qFlower))
    }
}