package com.rpgportugal.dicegoblin.dice.faces

interface Face {
    var enabled: Boolean
    fun getName(): String
    fun getSymbol(): String
    fun getValue() : Int
}