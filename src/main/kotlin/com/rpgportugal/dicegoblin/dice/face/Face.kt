package com.rpgportugal.dicegoblin.dice.face

data class Face(
    val score : Int,
    val symbol : String? = score.toString()) {

    fun combine(face: Face, scoreCombine: (Int, Int) -> Int) : Face {
        val s = when {
            symbol == null -> face.symbol
            face.symbol == null -> symbol
            else -> null
        }

        return Face(scoreCombine(score, face.score), s)
    }
}
