package com.rpgportugal.dicegoblin.parser

import com.rpgportugal.dicegoblin.dice.DiceFactory
import com.rpgportugal.dicegoblin.expression.Expression
import com.rpgportugal.dicegoblin.expressions.StaticValueExpression
import com.rpgportugal.dicegoblin.expressions.dice.NumberDiceExpression
import com.rpgportugal.dicegoblin.expressions.modifiers.ModifierFactory

class ValueParser(val valueContext: DiceNotationParser.ValueContext) : ContextParser {

    val diceFactory = DiceFactory()

    override fun parse(): Expression {
        return if (valueContext.dice() != null) {
            val faceAndModifier = valueContext.dice().faceAndModifier().text

            val dice = diceFactory.getDice(faceAndModifier)
            val remainder = diceFactory.getInputRemainder(faceAndModifier)

            NumberDiceExpression(
                valueContext.dice()?.nrdice()?.text?.toInt() ?: 0,
                dice,
                ModifierFactory().getModifier(remainder)
            )
        } else {
            StaticValueExpression(valueContext.staticVal().text.toInt())
        }
    }
}