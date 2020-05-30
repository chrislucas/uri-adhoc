package sample

// http://codeforces.com/contest/1347/problem/B

object IsSquare {
    fun solver() {
        var cases = readLine()?.toInt()
        cases?.let {
            while (cases > 0) {
                var line = readLine()?.split(" ")
                val pa = line?.let {
                    Pair(it[0].toInt(), it[1].toInt())
                }
                line = readLine()?.split(" ")
                val pb = line?.let {
                    Pair(it[0].toInt(), it[1].toInt())
                }

                if (pa != null && pb != null) {

                    val ax1 = pa.first + pb.first       // vertical sum
                    val ax2 = pa.second + pb.second     // horizontal sum
                    val ax3 = pa.first + pb.second      // vertical + horizontal
                    val ax4 = pa.second + pb.first      // horizontal + vertical

                    if (ax1 == pa.second && ax1 == pb.second
                        || ax2 == pa.first && ax2 == pb.first
                        || ax3 == pa.second && ax3 == pb.first
                        || ax4 == pa.first && ax4 == pb.second
                    ) {
                        println("YES")
                    } else {
                        println("NO")
                    }
                }
                cases--
            }
        }

    }
}

fun main() {
    IsSquare.solver()
}