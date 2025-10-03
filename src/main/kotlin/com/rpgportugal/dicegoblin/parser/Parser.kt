package com.rpgportugal.dicegoblin.parser

import com.rpgportugal.dicegoblin.expressions.ExpressionResult
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

fun parse(diceExpression: String): ExpressionResult {
    val lexer = DiceNotationLexer(CharStreams.fromString(diceExpression))
    val parser = DiceNotationParser(CommonTokenStream(lexer))
    val ctx = parser.input_()
    val expression = OperationParser(ctx.operation()).parse()
    return expression.evaluate()
}