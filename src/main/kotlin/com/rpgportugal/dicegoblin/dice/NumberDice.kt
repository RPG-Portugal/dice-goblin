package com.rpgportugal.dicegoblin.dice

import com.rpgportugal.dicegoblin.dice.faces.Face
import com.rpgportugal.dicegoblin.dice.faces.NumberFace

class NumberDice (val nrFaces: String) : Dice(nrFaces) {

    override fun getFaces(): List<Pair<Face, Double>> =
        (1..nrFaces.toInt()).map { i -> NumberFace(i) to 1.0 }

    override fun getName(): String = nrFaces

}