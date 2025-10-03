package com.rpgportugal.dicegoblin.parser

import com.rpgportugal.dicegoblin.expressions.dice.NumberDiceExpression
import org.junit.jupiter.api.Test
import kotlin.test.expect

class ParserKtTest {

    @Test
    fun `test single dice`(){
        val result = parse("1d8")

        expect("NumberDiceExpression", "Unexpected class type") { result.expression.javaClass.simpleName}
        expect(1, "Unexpected dice number") { (result.expression as NumberDiceExpression).numberOfDice }
        expect(8, "Unexpected face number") { (result.expression as NumberDiceExpression).diceType.getFaces().size }
    }

    @Test
    fun `test single operation`(){
        val result = parse("1d10+5")

        expect("AddOperatorExpression", "Unexpected class type") { result.expression.javaClass.simpleName}
        expect(2, "Unexpected number of operation children") { result.subResults.size }
        expect("NumberDiceExpression", "Unexpected first child") { (result.subResults[0].expression.javaClass.simpleName) }
        expect("StaticValueExpression", "Unexpected second child") { (result.subResults[1].expression.javaClass.simpleName) }
    }

    @Test
    fun `test two operations with modifiers`(){
        val result = parse("2d20kh+3d6kh2")

        expect("AddOperatorExpression", "Unexpected class type") { result.expression.javaClass.simpleName}
        expect(2, "Unexpected number of operation children") { result.subResults.size }
        expect("NumberDiceExpression", "Unexpected first child") { (result.subResults[0].expression.javaClass.simpleName) }
        expect("NumberDiceExpression", "Unexpected second child") { (result.subResults[1].expression.javaClass.simpleName) }
    }

    @Test
    fun `test fate dice`(){
        val result = parse("4df")

        print(result.resultList.joinToString(",") { it.getName() })
        expect("NumberDiceExpression", "Unexpected class type") { result.expression.javaClass.simpleName}
    }
}