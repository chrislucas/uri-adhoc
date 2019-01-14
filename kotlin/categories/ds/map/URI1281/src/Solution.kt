/**
 * https://www.urionlinejudge.com.br/judge/en/problems/view/1281
 * DONE
 * */

fun readInt() =  readLine()?.toInt()

fun main(args: Array<String>) {
    var trips = readInt()
    while (trips != null && trips > 0) {

        var products = readInt()
        val mapProductsForSale = mutableMapOf<String?, Double?>()
        while (products != null && products>0) {
            val values = readLine()?.split(" ")
            mapProductsForSale[values?.get(0)] = values?.get(1)?.toDouble()
            products--;
        }

        products = readInt()
        var acc = 0.0
        while (products != null && products>0) {
            val values = readLine()?.split(" ")
            val price = mapProductsForSale[values?.get(0)] ?: 0.0
            val qtd = values?.get(1)?.toInt() ?: 0
            acc += price *  qtd
            products--;
        }

        println(String.format("R$ %.2f", acc))
        trips--;
    }
}