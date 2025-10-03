package com.rpgportugal.dicegoblin.expressions.modifiers

import com.rpgportugal.dicegoblin.expressions.ExpressionResult
import com.rpgportugal.dicegoblin.expressions.dice.NumberDiceExpression

class KeepHighestModifier(val expression: String) : Modifier {

    override fun getIdentifier(): Regex = Regex("kh(\\d*)")

    override fun modifyResult(inp: ExpressionResult): ExpressionResult {
        if (inp.expression !is NumberDiceExpression) return inp
        val keepNr = evaluateKeepNumber(getIdentifier().matchEntire(expression)?.groups?.get(1)?.value)
        inp.resultList.sortedBy { it.getValue() }.reversed().drop(keepNr).forEach { it.enabled = false }
        return inp
    }

    fun evaluateKeepNumber(inp: String?):Int {
        if( inp.isNullOrEmpty() ) return 1
        return inp.toInt()
    }
}