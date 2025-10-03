package com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.dicegoblin.dice.NumberDice
import com.rpgportugal.dicegoblin.expressions.StaticValueExpression
import com.rpgportugal.dicegoblin.expressions.dice.NumberDiceExpression
import kotlin.test.Test
import kotlin.test.assertEquals

class AddOperatorExpressionTest {

    @Test
    fun `Tests adding two statics`() {
        val staticLeft = StaticValueExpression(4)
        val staticRight = StaticValueExpression(10)

        val addOp = AddOperatorExpression(staticLeft, staticRight)

        assertEquals(14, addOp.calculate())
    }

    @Test
    fun `Tests adding a NumberDice and a static`() {
        val staticLeft = NumberDiceExpression(3, NumberDice("6"), null)
        val staticRight = StaticValueExpression(1)

        val addOp = AddOperatorExpression(staticLeft, staticRight)

        assert(addOp.calculate() in 4..19 )
    }

    @Test
    fun `Tests if the expressionResults match the final result`() {
        val staticLeft = NumberDiceExpression(3, NumberDice("6"), null)
        val staticRight = StaticValueExpression(1)

        val addOp = AddOperatorExpression(staticLeft, staticRight)
        val result = addOp.evaluate()

        assert( result.resultList.sumOf {it.getValue()} ==
                result.subResults.sumOf { it.resultList.sumOf { res -> res.getValue() } })
    }

}