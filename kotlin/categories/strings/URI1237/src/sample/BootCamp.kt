package sample
// http://codeforces.com/contest/1346/problem/B
// DONE
object BootCamp {

    fun readInt() = readLine()!!.toInt()

    fun readInts(del: String) = readLine()!!.split(del).map { it.toInt() }.toTypedArray()

    @JvmStatic
    private fun solver(code: String, inf: Int, sup: Int) : Int {
        var acc = 0
        val memo =  Array(code.length) {0}
        for (i in code.indices) {
            if (code[i] == '1') {
                if (i-1>=0) {
                    if (inf + memo[i-1] > sup) {
                        memo[i] = sup - inf
                        acc += memo[i]
                    }
                    else {
                        memo[i] = inf
                        acc += memo[i]
                    }
                }
                else {
                    memo[i] = inf
                    acc += inf
                }
            }
        }
        return acc
    }

    @JvmStatic
    fun solver() {
        var cases = readInt()
        while (cases > 0) {
            val (n, a, b) = readInts(" ")
            val code = readLine()
            code?.let {
                println(solver(it, a, b))
            }
            cases--
        }
    }
}




fun main() {
    BootCamp.solver()
}