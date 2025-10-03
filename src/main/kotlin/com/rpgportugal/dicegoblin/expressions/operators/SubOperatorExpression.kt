package com.rpgportugal.dicegoblin.expressions.operators

import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.expressions.OperatorCompanion
import com.rpgportugal.dicegoblin.expressions.OperatorExpression

class SubOperatorExpression(
    override val left: Expression,
    override val right: Expression,
) : OperatorExpression {

    override val calculationFn: (Int, Int) -> Int
        get() = {a,b -> a-b}

    companion object : OperatorCompanion {
        override fun getOperatorSymbol(): String {
            return "-"
        }

        override fun getInstance(
            left: Expression,
            right: Expression
        ): OperatorExpression = SubOperatorExpression(left, right)
    }


}