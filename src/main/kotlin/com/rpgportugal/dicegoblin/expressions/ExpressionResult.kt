package com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.dicegoblin.dice.faces.Face
import com.rpgportugal.dicegoblin.expression.Expression

class ExpressionResult(
    val expression: Expression,
    val resultList: List<Face>,
    val subResults: List<ExpressionResult>
) {
}