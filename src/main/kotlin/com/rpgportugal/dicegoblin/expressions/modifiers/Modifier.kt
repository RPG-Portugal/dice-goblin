package com.rpgportugal.dicegoblin.expressions.modifiers

import com.rpgportugal.dicegoblin.expressions.ExpressionResult

interface Modifier {
    fun getIdentifier(): Regex

    fun modifyResult(inp: ExpressionResult): ExpressionResult
}