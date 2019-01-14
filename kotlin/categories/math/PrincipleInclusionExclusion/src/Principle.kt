
/**
 *
 * Principio de inclusao-exclusao
 *
 * Sum rule =
 * A ou B = A + B - (A e B)
 *
 * */


// quantos numeros entre 1 e N sao divisiveis por A ou B
// (n / a) = quantidade de numeros divisiveis por a
// (n / b) = idem b
// (n / b) = idem por a e b
fun countingDivisors(n: Int, a: Int, b: Int) = (n / a) + (n / b) - ( n / (a * b))


fun countSetBits(n: Int) : Int {
    var acc = 0
    var n = n
    while (n>0) {
        n = n and (n - 1)
        acc += 1
    }
    return acc
}

/**
 * Seja S um conjunto de numeros primos e M um numero qualquer > 0
 * descubra quantos numeros de 1 a M sao divisiveis por qualquer numero do conjunto S
 * */

fun computeDivisors(primes: Array<Int>, m: Int) : Int {
    var odd = 0
    var even = 0

    val size = primes.size
    for (i in 1 until (1 shl size)) {
        var  product = 1
        for (j in 0 until size) {
            //print(if (i and (1 shl j) > 0) primes[j].toString() + " " else "")
            //print(if (i and (1 shl j) > 0)  j.toString() + " " else "")
            if (i and (1 shl j) > 0) {
                product *= primes[j]
            }
        }
        /**
         *  a funcao que conta o numero de bits de um numero i funciona
         *  como se estivessemos contando a cardinalidade dum conjunto A(i)
         *  Exemplo:
         *  Se o conjunto/vetor primes tiver 3 numeros a formula de inclusao/exclusao ficaria
         *  As letras representam a cardinalidade do conjunto
         *  A e B eh multiplicacao da cardinalidade de A por B
         *  |A ou B ou C| = |A| + |B| + |C| - |A e B| - |A e C| - |B e C| + |A e B e C|
         *  Somamos os subconjuntos com quantidade impar e subtraimos as pares
         * */
        if (countSetBits(i) and 1 == 1)
            odd += (m / product)
        else
            even += (m / product)
        //println()
    }

    return odd - even
}


fun main(args: Array<String>) {
    //println(countingDivisors(1000, 3, 4))
    //println(computeDivisors(arrayOf(2,3,5), 100))
    println(computeDivisors(arrayOf(2,3,5,7), 100))
    println(computeDivisors(arrayOf(2,5,7,11), 200))
}