package com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.dicegoblin.dice.faces.NumberFace
import com.rpgportugal.dicegoblin.expression.Expression

class StaticValueExpression(
    val staticValue: Int,
) : Expression {
    override fun calculate(): Int {
        return staticValue
    }

    override fun evaluate(): ExpressionResult =
        ExpressionResult(this, listOf(NumberFace(staticValue)), listOf())
}