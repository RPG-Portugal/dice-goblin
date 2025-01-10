package com.rpgportugal.com.rpgportugal.dicegoblin.expression

import com.rpgportugal.dicegoblin.dice.Dice
import com.rpgportugal.dicegoblin.dice.face.Face

typealias RollFunc = Dice

sealed interface Expression {
    fun evaluate(random: () -> Int): Face

    interface BinaryOperator: Expression {
        val lhs: Expression
        val rhs: Expression

        fun combine(lhs :Face, rhs: Face): Face

        override fun evaluate(random: () -> Int): Face {
            return combine(lhs.evaluate(random), rhs.evaluate(random))
        }
    }

    data class Add(override val lhs: Expression, override val rhs: Expression): BinaryOperator {
        override fun combine(lhs: Face, rhs: Face): Face = lhs.combine(rhs) {s1, s2 -> s1 + s2}
    }

    data class Sub(override val lhs: Expression, override val rhs: Expression): BinaryOperator {
        override fun combine(lhs: Face, rhs: Face): Face = lhs.combine(rhs) {s1, s2 -> s1 - s2}
    }

    data class Number(val value: Int) : Expression {
        override fun evaluate(random: () -> Int): Face = Face.Number(value)
    }

    data class Dice(val dice: RollFunc) : Expression {
        override fun evaluate(random: () -> Int): Face {
            return dice.roll(random())
        }

    }
}


