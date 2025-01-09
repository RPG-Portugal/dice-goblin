package com.rpgportugal.com.rpgportugal.dicegoblin.expressions.dice

import com.rpgportugal.com.rpgportugal.dicegoblin.common.getWeightedRandom
import com.rpgportugal.com.rpgportugal.dicegoblin.dice.NumberDice
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.IExpression
import com.rpgportugal.com.rpgportugal.dicegoblin.expressions.ExpressionResult

class NumberDiceExpression(
    val numberOfDice: Int,
    val diceType: NumberDice,
) : IExpression {
    override fun calculate(): Int =
        (1..numberOfDice).sumOf {
            diceType.getFaces().entries.getWeightedRandom { member -> member.value }.key.getValue()
        }

    override fun evaluate(): ExpressionResult =
         ExpressionResult(
            this,
            (1..numberOfDice).map {
                diceType.getFaces().entries.getWeightedRandom { member -> member.value }.key
            },
            listOf()
            )

}