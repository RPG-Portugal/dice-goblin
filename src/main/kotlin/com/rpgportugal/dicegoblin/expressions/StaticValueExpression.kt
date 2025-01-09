package com.rpgportugal.com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.NumberFace
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.IExpression

class StaticValueExpression(
    val staticValue: Int,
) : IExpression {
    override fun calculate(): Int {
        return staticValue
    }

    override fun evaluate(): ExpressionResult =
        ExpressionResult(this, listOf(NumberFace(staticValue)), listOf())
}