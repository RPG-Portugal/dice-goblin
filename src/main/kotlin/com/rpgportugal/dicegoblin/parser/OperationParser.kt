package com.rpgportugal.dicegoblin.parser

import com.rpgportugal.dicegoblin.common.isEmpty
import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.expressions.operators.AddOperatorExpression
import com.rpgportugal.dicegoblin.expressions.operators.SubOperatorExpression

class OperationParser (val operationContext: DiceNotationParser.OperationContext) : ContextParser {

    val operatorExpression = listOf(AddOperatorExpression, SubOperatorExpression)

    override fun parse() : Expression{
        return if(operationContext.OPERATOR()?.isEmpty() != false){
            ValueParser(operationContext.value(0)).parse()
        } else {
            val op =
                operatorExpression.find { opComp -> opComp.getOperatorSymbol() == operationContext.OPERATOR().text }
                    ?: throw Exception("Bad operator")
            if (operationContext.operation() != null) {
                op.getInstance(
                    OperationParser(operationContext.operation()).parse(),
                    ValueParser(operationContext.value(0)).parse()
                )
            } else {
                op.getInstance(
                    ValueParser(operationContext.value(0)).parse(),
                    ValueParser(operationContext.value(1)).parse()
                )
            }
        }
    }

}
