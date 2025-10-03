package com.rpgportugal.dicegoblin.expressions.dice

import com.rpgportugal.dicegoblin.dice.Dice
import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.expressions.ExpressionResult
import com.rpgportugal.dicegoblin.expressions.modifiers.Modifier

class NumberDiceExpression(
    val numberOfDice: Int,
    val diceType: Dice,
    val modifier: Modifier?,
) : Expression {
    override fun calculate(): Int =
        (1..numberOfDice).sumOf {
            diceType.roll().getValue()
        }

    override fun evaluate(): ExpressionResult {
        val result = ExpressionResult(
            this,
            (1..numberOfDice).map {
                diceType.roll()
            },
            listOf()
        )

        return modifier?.modifyResult(result) ?: result
    }


}