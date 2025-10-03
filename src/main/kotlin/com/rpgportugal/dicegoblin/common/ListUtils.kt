package com.rpgportugal.dicegoblin.common

fun <T>Collection<T>.getWeightedRandom(fn:(member:T)->Double): T {
    val randomNumber = Math.random() * this.sumOf{ fn(it) }
    var probabilityIterator = 0.0
    this.forEach {
        probabilityIterator += fn(it)
        if(probabilityIterator >= randomNumber) {
            return it
        }
    }
    return this.random()
}