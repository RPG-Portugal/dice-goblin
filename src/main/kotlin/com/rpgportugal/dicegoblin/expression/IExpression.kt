package com.rpgportugal.com.rpgportugal.dicegoblin.expression

import com.rpgportugal.com.rpgportugal.dicegoblin.expressions.ExpressionResult

interface IExpression {

    fun calculate() : Int

    fun evaluate() : ExpressionResult

}