

// * spread operador
fun <P, Q> createMutableMap(vararg values: Pair<P, Q>) = mutableMapOf(*values)


fun <P, Q> createImmutableMap(vararg values: Pair<P, Q>) = mapOf(*values)

fun <P : Comparable<P>, Q> createSortedMap(vararg values: Pair<P, Q>) = sortedMapOf(*values)

fun <P, Q> createLinkedHashMap(vararg values: Pair<P, Q>) = linkedMapOf(*values)

fun <P, Q> createHashMap(vararg values: Pair<P, Q>) = hashMapOf(*values)



fun testMutableMap() {
    val mutableMap = createMutableMap(1 to "a", 2 to "b", 3 to "c")
    mutableMap[4] = "d"
    mutableMap.put(8, "h")
    println(mutableMap)
    mutableMap.remove(8)
    println(mutableMap)
    mutableMap.clear()
    println(mutableMap)
}


fun testImmutableMap() {
    // funcao que devolve um valor padrao caso mapa nao possuir uma determinada chave
    val immutableMap = createImmutableMap(1 to "a", 2 to "b", 3 to "b").withDefault { "NF" }

    // o metodo getValue lanca uma excecao caso a chave nao exista no mapa
    // porem com o uso do metodo withDefault agora o metodo retorna uma string caso a chave nao existir
    println(immutableMap.getValue(4))
    println(immutableMap)
    println(immutableMap.filter { it -> it.key and 1 == 1})

    //immutableMap.let { it.forEach { t, u ->  } }
    //immutableMap.run { this.forEach { k, v -> } }


    /**
     *
     * A funcao with eh uma scope funtion diferente as demais (let, also, run, apply)
     * pois eh implementada de forma independente de um objeto, ou seja nao
     * a chamamos a partir de uma referencia como as outras funcoes, diferente
     * das outras funcoes, a funcao "with recebe como argumento uma referencia
     * de um objeto e uma function with receiver (uma funcao que se comporta como uma
     * extension function temporaria dentro do escopo da funcao que foi executada anteriormente,
     * para o tipo de instancia passado no primeiro parametro do metodo)
     * Assim
     * */

    val fnReceiver : (map: Map<Int, String>) -> String  = {
        it ->
            val str = StringBuilder()
            it.forEach { k, v-> str.append("$k to $v \n") }
                str.toString()
    }
    // a funcao with retorna o valor da funcao fnReceiver
    val rs = with(immutableMap, fnReceiver)
    println(rs)
/*
    with(immutableMap) {
        // function with receiver ou uma de forma simplificada uma funcao de extensao temporaria
        this.forEach {k, v -> ""}
    }
  */
}


fun testSortedMap() {
    val sortedMap = createSortedMap(3 to "Fernandes"
        , 4  to "Santos", 1 to "Christoffer", 2 to "Lucas")

    println(sortedMap)
    sortedMap[0] = "Chris"
    println(sortedMap)
    sortedMap[1] = "Paulo"
    println(sortedMap)
}





fun main(args: Array<String>) {
    //testMutableMap()
    //testImmutableMap()
    testSortedMap()
}