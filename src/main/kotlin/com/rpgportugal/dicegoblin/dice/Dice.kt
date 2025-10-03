package com.rpgportugal.dicegoblin.dice

import com.rpgportugal.dicegoblin.dice.faces.Face

abstract class Dice(open val inp: String) {
    abstract fun getFaces(): List<Pair<Face, Double>>

    abstract fun getName(): String
    fun roll(): Face = this.getFaces().random().first
}