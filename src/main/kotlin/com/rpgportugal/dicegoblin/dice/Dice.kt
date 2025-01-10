package com.rpgportugal.dicegoblin.dice

import com.rpgportugal.dicegoblin.dice.face.Face

fun interface Dice {
    fun roll(index: Int): Face

    companion object {

        fun generic(faces: List<Face>): Dice = Dice {
            faces[it % faces.size]
        }

        fun numeric(size: Int): Dice =
            (1 .. size)
                .map { Face(it) }
                .toList()
                .let(::generic)

        fun repeated(faces: List<Pair<Face,Int>>): Dice =
            faces.flatMap {(face, i) -> (0 ..< i).map { face } }
                .toList()
                .let(::generic)

    }
}