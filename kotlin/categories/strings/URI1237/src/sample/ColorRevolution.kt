package sample

// http://codeforces.com/contest/1346/problem/A
// DONE
object ColorRevolution {
    @JvmStatic
    fun solver() {
        val line = readLine()
        if (line != null) {
            var cases = line.toInt()
            while (cases > 0) {
                val numbers : Array<Int> = readLine()!!
                    .split(" ")
                    .map { it.toInt() }
                    .toTypedArray()
                val (n, k) = numbers
                val a = n / (1 + k + (k*k) + (k*k*k))
                println("$a ${a*k} ${a*k*k} ${a*k*k*k}")
                cases--
            }
        }
    }
}

fun main() {
    ColorRevolution.solver()
}