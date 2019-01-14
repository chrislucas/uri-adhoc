package collections

import java.io.File

/**
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html
 *
 * https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/with-default.html
 * */

// Um mapa imutavel que possui um valor padrao para retorno quando for procurado por
// uma chave que nao existe nele
fun <P, Q> createImmutableMapWithDefault(vararg values: Pair<P, Q>, def: Q) = mapOf(*values).withDefault { def }


fun helperBuildFrequency1(words: List<String>) : Map<String, Long> {
    val frequency = mutableMapOf<String, Long>()
    words.forEach {
            w ->
        if (w in frequency) {
            // a linha abaixo nao compila
            // frequency[w] += 1
            // porque map[key] eh a mesma coisa que map.get(key)
            // onde o metodo get retorna T?, um possivel valor nulo
            // e por seguranca o compilador nao permite isso afim de evitar em tempo
            // de execucao uma soma onde uma das partes eh nula

            // s linhs abaixo compila
            frequency[w] = frequency[w]?.plus(1) ?: 0

            // elvis operator
            //frequency[w] = (frequency[w] ?: 0 ) + 1
        }
        else {
            frequency[w] = 1
        }
    }

    val comp = Comparator<Pair<String, Long>> {
            p, q ->
        val diff = p.second - q.second
        var rs = -1
        if(diff == 0L) { rs = 0 }
        else if (diff > 0) { rs = 1 }
        rs
    }
    frequency.toList().sortedWith(comp).toMap()

    // ordenar o mapa por valor
    //val nf = frequency.toList().sortedBy { ( _, value) -> -value }.toMap()

    return frequency
}

fun helperBuildFrequency2(words: List<String>) : Map<String, Long> {
    val frequency = mutableMapOf<String, Long>()
    words.forEach {
        w ->
            val old = frequency[w]
            if (old != null) {
                frequency[w] = old + 1
            }
            else {
                frequency[w] = 1
            }
    }
    return frequency
}


fun <Data> helperBuildFrequency3(values: List<Data>, defaultValue: Long) : Map<Data, Long> {
    val frequency = mutableMapOf<Data, Long>().withDefault { defaultValue }
    values.forEach {
        k ->
        // se o mapa em que estamos tentado recuperar o valor nao tiver um valor padroa (withDefault)
        // e o metodo getValue(key) nao encontrar tal key no mapa, esse metodo lancara a excecao NoSuchElementException
        frequency[k] = if (k in frequency) frequency.getValue(k) + 1 else 1
    }

    // poderia trocar o uso da funcao withDefault por
    // frequency.getOrDefault(k, defaultValue)
    // ou, caso nao seja apropriado dar um valor padrao para o mapa inteiro
    // frequency.getOrElse(k) { }

    return frequency
}


fun buildFrequency(words: List<String>) = helperBuildFrequency2(words)


fun buildFrequency(words: List<String>, defaultValue : Long) = helperBuildFrequency3(words, defaultValue)


fun main(args: Array<String>) {
    val words = arrayListOf<String>()
    File("raw/lorenipsum_test").readLines().forEach {
        line -> words.addAll(line.split(" "))
    }
    val frequencyWords = buildFrequency(words, 0L)

    println(frequencyWords.getOrDefault("loren", 0))

    println( frequencyWords.getOrElse("test")
        {
            println("Key not found")
            0
        }
    )

}