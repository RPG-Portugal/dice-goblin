package com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces

class NumberFace (val nr : Int) : IFace {
    override fun getValue(): Int = nr
}