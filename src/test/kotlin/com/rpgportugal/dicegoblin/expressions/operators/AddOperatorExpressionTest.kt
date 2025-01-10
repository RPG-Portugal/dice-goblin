package com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.dice.Dice
import com.rpgportugal.dicegoblin.dice.face.Face
import kotlin.test.Test
import kotlin.test.assertEquals

class AddOperatorExpressionTest {

    @Test
    fun `Tests adding two statics`() {
        val lhs = Expression.Number(4)
        val rhs = Expression.Number(10)

        val add = Expression.Add(lhs, rhs)

        assertEquals(14, add.evaluate { 0 }.value)
    }

    @Test
    fun `Tests adding a NumberDice and a static`() {
        val lhs = Expression.Dice(Dice.numeric(3))
        val rhs = Expression.Number(1)

        val add = Expression.Add(lhs, rhs)

        assertEquals(Face.Dice(4,"3"), add.evaluate { 2 })
    }

    @Test
    fun `Tests if the expressionResults match the final result`() {
        val lhs = Expression.Dice(Dice.numeric(2))
        val rhs = Expression.Number(1)

        val add  = Expression.Add(lhs, rhs)

        val result = add.evaluate { 1 }

        assertEquals(Face.Dice(3, "2"), result)
    }

}