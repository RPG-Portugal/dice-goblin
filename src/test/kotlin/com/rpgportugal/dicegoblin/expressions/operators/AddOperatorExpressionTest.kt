package com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.dice.Dice
import com.rpgportugal.dicegoblin.dice.face.Face
import kotlin.test.Test
import kotlin.test.assertEquals

class AddOperatorExpressionTest {

    @Test
    fun `Tests adding two statics`() {
        val staticLeft = Expression.Number(4)
        val staticRight = Expression.Number(10)

        val addOp = Expression.Add(staticLeft, staticRight)

        assertEquals(14, addOp.evaluate { 0 }.value)
    }

    @Test
    fun `Tests adding a NumberDice and a static`() {
        val l = Expression.Dice(Dice.numeric(3))
        val r = Expression.Number(1)

        val addExpr = Expression.Add(l, r)

        assertEquals(Face.Dice(4,"3"), addExpr.evaluate { 2 })
    }

    @Test
    fun `Tests if the expressionResults match the final result`() {
        val staticLeft = Expression.Dice(Dice.numeric(2))
        val staticRight = Expression.Number(1)

        val addExpr  = Expression.Add(staticLeft, staticRight)
        val result = addExpr.evaluate { 1 }

        assertEquals(Face.Dice(3, "2"), result)
    }

}