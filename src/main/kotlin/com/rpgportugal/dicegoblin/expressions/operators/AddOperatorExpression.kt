package com.rpgportugal.com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.NumberFace
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.IExpression
import com.rpgportugal.com.rpgportugal.dicegoblin.expressions.ExpressionResult
import com.rpgportugal.com.rpgportugal.dicegoblin.expressions.IOperatorExpression

class AddOperatorExpression(
    override val left: IExpression,
    override val right: IExpression
) : IOperatorExpression {
    override fun calculate(): Int =
        left.calculate() + right.calculate()

    override fun evaluate(): ExpressionResult {
        val leftResult = left.evaluate()
        val rightResult = right.evaluate()
        return ExpressionResult(this,
            listOf(NumberFace(leftResult.resultList.sumOf{it.getValue()}+rightResult.resultList.sumOf{it.getValue()}) ),
            listOf(leftResult, rightResult))
    }
}