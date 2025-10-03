package com.rpgportugal.dicegoblin.dice.faces

class FateFace (val face : FateFaceEnum) : Face {
    override var enabled = true
    override fun getName(): String = face.name
    override fun getSymbol(): String = face.symbol
    override fun getValue(): Int = face.value
}