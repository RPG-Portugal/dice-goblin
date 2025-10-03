package com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.dicegoblin.dice.faces.NumberFace
import com.rpgportugal.dicegoblin.expression.Expression

interface OperatorCompanion {
    fun getOperatorSymbol():String
    fun getInstance(left: Expression, right: Expression): OperatorExpression
}

interface OperatorExpression : Expression {
    val left: Expression
    val right: Expression

    val calculationFn : (a:Int, b:Int) -> Int

    override fun calculate(): Int {
        return calculationFn.invoke(left.calculate(), right.calculate())
    }

    override fun evaluate(): ExpressionResult {
        val leftResult = left.evaluate()
        val rightResult = right.evaluate()

        val leftResultSum = leftResult.resultList.filter{it.enabled}.sumOf{it.getValue()}
        val rightResultSum = rightResult.resultList.filter{it.enabled}.sumOf{it.getValue()}

        return ExpressionResult(this,
            listOf(NumberFace(calculationFn.invoke(leftResultSum, rightResultSum))),
            listOf(leftResult, rightResult))
    }

}