
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


/**
 * Seja S um conjunto de numeros primos e M um numero qualquer > 0
 * descobra quantos numeros de 1 a M sao divisiveis por qualquer numero do conjunto S
 * */


fun computeDivisors(primes: Array<Int>, m: Int) : Int {
    var acc = 0
    return acc
}


fun main(args: Array<String>) {
    println(countingDivisors(1000, 3, 4))


    println(computeDivisors(arrayOf(2,3,5,7), 100))
    println(computeDivisors(arrayOf(2,5,7,11), 200))
}