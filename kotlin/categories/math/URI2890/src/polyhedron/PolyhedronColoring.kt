package polyhedron

import kotlin.math.round

/**
 * http://mathworld.wolfram.com/PolyhedronColoring.html
 * */

fun multiplyMod(a: Long, b: Long, m: Long) = ((a%m)*(b%m))%m

fun sumMod(a: Long, b: Long, m: Long) = ((a%m)+(b%m))%m

fun simpleExp(b: Long, e: Long) : Long {
    return when (e) {
        0L -> 1
        1L -> b
        else  -> {
            var b = b
            var e = e
            var acc = 1L
            while (e > 0) {
                if ( (e and 1) == 1L) {
                    acc*= b
                }
                b *= b
                e = e shr 1
            }
            acc
        }
    }
}

const val M = 1000007L

fun coloringCube(n: Long) = round( 1.0/3.0*simpleExp(n, 2) + 1.0/2.0*simpleExp(n, 3)+ 1.0/8.0*simpleExp(n, 4) + 1.0/24.0*simpleExp(n, 6) )


// fun coloringTetrahedron(n: Long) = sumMod(round(11.0/12.0*simpleExp(n, 2)).toLong(), round(1.0/12.0*simpleExp(n, 4)).toLong(), M)

fun coloringTetrahedron(n: Long) = round(11.0/12.0*simpleExp(n, 2) + 1.0/12.0*simpleExp(n, 4))


fun coloringOctahedron(n: Long) = round( 1.0/4.0* simpleExp(n, 2) + 17.0/24.0* simpleExp(n, 4) + 1.0/24.0* simpleExp(n, 8))


fun testColoringCube() {
    for (i in 0 .. 10L)
        print((if (i == 0L) "%f" else " %f").format(coloringCube(i)))
    println("")
}

fun testColoringTetrahedron() {
    for (i in 0 .. 10L)
        print((if (i == 0L) "%d -> %f" else " %d -> %f").format(i, coloringTetrahedron(i)))
    println("")
}


fun testColoringOctahedron() {
    for (i in 0 .. 10L)
        print((if (i == 0L) "%f" else " %f").format(coloringOctahedron(i)))
    println("")
}


fun main(args: Array<String>) {
    testColoringCube()
    testColoringTetrahedron()
    testColoringOctahedron()
}