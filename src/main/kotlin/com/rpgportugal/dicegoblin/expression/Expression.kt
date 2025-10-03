package com.rpgportugal.dicegoblin.expression

import com.rpgportugal.dicegoblin.expressions.ExpressionResult

interface Expression {

    fun calculate() : Int

    fun evaluate() : ExpressionResult

}