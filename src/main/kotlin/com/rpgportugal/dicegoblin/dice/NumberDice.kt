package com.rpgportugal.com.rpgportugal.dicegoblin.dice

import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.IFace
import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.NumberFace

class NumberDice (val nrFaces: Int) : IDice {

    override fun getFaces(): Map<IFace,Double> =
        (1..nrFaces).associate { i -> NumberFace(i) to 1.0 }

}