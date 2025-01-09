package com.rpgportugal.com.rpgportugal.dicegoblin.expressions

import com.rpgportugal.com.rpgportugal.dicegoblin.expression.IExpression

interface IOperatorExpression : IExpression {
    val left: IExpression
    val right: IExpression
}