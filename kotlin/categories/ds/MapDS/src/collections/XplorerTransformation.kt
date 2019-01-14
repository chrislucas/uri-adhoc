package collections

import java.io.File

// Collection Transformations
// https://blog.danlew.net/2017/06/14/convincing-the-kotlin-compiler-that-code-is-safe/


fun groupingWords() {
    val words = arrayListOf<String>()
    File("raw/lorenipsum_test").readLines().forEach {
            line -> words.addAll(line.split(" "))
    }

    words.groupBy { it }.onEach {
        entry ->  println("${entry.key}, ${entry.value.size}")
    }
}

fun main(args: Array<String>) {
    groupingWords()
}