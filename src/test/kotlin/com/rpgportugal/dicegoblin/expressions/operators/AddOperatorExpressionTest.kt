package com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.com.rpgportugal.dicegoblin.expression.AddExpr
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.DiceExpr
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.NumericExpr
import com.rpgportugal.dicegoblin.dice.Dice
import com.rpgportugal.dicegoblin.dice.face.Face
import kotlin.test.Test
import kotlin.test.assertEquals

class AddOperatorExpressionTest {

    @Test
    fun `Tests adding two statics`() {
        val staticLeft = NumericExpr(4)
        val staticRight = NumericExpr(10)

        val addOp = AddExpr(staticLeft, staticRight)

        assertEquals(14, addOp.evaluate { 0 }.score)
    }

    @Test
    fun `Tests adding a NumberDice and a static`() {
        val l = DiceExpr(Dice.numeric(3))
        val r = NumericExpr(1)

        val addExprOp = AddExpr(l, r)

        assertEquals(4, addExprOp.evaluate { 2 }.score)
    }

    @Test
    fun `Tests if the expressionResults match the final result`() {
        val staticLeft = DiceExpr(Dice.numeric(2))
        val staticRight = NumericExpr(1)

        val addOp  = AddExpr(staticLeft, staticRight)
        val result = addOp.evaluate { 1 }

        assertEquals(Face(3, "2"), result)
    }

}