package com.rpgportugal.dicegoblin.dice

import com.rpgportugal.dicegoblin.dice.faces.Face
import com.rpgportugal.dicegoblin.dice.faces.FateFace
import com.rpgportugal.dicegoblin.dice.faces.FateFaceEnum

class FateDice (override val inp: String) : Dice(inp) {

    override fun getFaces(): List<Pair<Face, Double>> =
        listOf(
            FateFace(FateFaceEnum.PLUS) to FateFaceEnum.PLUS.value.toDouble(),
            FateFace(FateFaceEnum.PLUS) to FateFaceEnum.PLUS.value.toDouble(),
            FateFace(FateFaceEnum.MINUS) to FateFaceEnum.MINUS.value.toDouble(),
            FateFace(FateFaceEnum.MINUS) to FateFaceEnum.MINUS.value.toDouble(),
            FateFace(FateFaceEnum.NULL) to FateFaceEnum.NULL.value.toDouble(),
            FateFace(FateFaceEnum.NULL) to FateFaceEnum.NULL.value.toDouble(),
        )

    override fun getName(): String = "f"

}