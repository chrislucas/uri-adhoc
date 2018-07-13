package io


fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)

fun main(args: Array<String>) {
    val (a, b) = readInts(' ')
    println(a)
    println(b)
}