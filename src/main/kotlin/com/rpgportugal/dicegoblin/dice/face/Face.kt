package com.rpgportugal.dicegoblin.dice.face

sealed interface Face {
    val value: Int
    fun combine(other: Face, combiner: (Int, Int) -> Int): Face

    data class Number(override val value: Int) : Face {
        override fun combine(other: Face, combiner: (Int, Int) -> Int): Face {
            val combinedValue = combiner(value, other.value)
            return when (other) {
                is Dice -> Dice(combinedValue, other.symbol)
                is Number -> Number(combinedValue)
            }
        }
    }

    data class Dice(override val value : Int, val symbol : String = value.toString()) : Face {
        override fun combine(other: Face, scoreCombine: (Int, Int) -> Int) : Face {
            val combinedScore = scoreCombine(value, other.value)
            return when (other) {
                is Dice -> Number(combinedScore)
                is Number -> Dice(combinedScore, symbol)
            }
        }
    }

}
