package com.rpgportugal.dicegoblin.dice

class DiceFactory {
    val dices = listOf(
        Regex("^([fF])(.*)") to ::FateDice,
        Regex("^([1-9]\\d*)(.*)") to ::NumberDice,
    )

    fun getInputRemainder(inp: String): String {
        for (dice in dices) {
            val match = dice.first.matchEntire(inp) ?: continue
            return match.groupValues[2]
        }
        throw Exception("Unsupported dice type")
    }

    fun getDice(inp: String): Dice{
        for (dice in dices) {
            val match = dice.first.matchEntire(inp) ?: continue
            return dice.second(match.groupValues[1])

        }
        throw Exception("Unsupported dice type")
    }
}