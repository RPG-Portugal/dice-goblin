package com.rpgportugal.com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.IFace
import com.rpgportugal.com.rpgportugal.dicegoblin.expression.IExpression

class ExpressionResult(
    val expression: IExpression,
    val resultList: List<IFace>,
    val subResults: List<ExpressionResult>
) {
}