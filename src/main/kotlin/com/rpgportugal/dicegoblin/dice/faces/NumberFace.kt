package com.rpgportugal.dicegoblin.dice.faces

class NumberFace (val nr : Int) : Face {
    override var enabled = true
    override fun getName(): String = this.nr.toString()
    override fun getSymbol(): String = this.nr.toString()
    override fun getValue(): Int = nr

}