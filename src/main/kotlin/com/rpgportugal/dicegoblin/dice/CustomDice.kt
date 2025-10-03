package com.rpgportugal.dicegoblin.dice

interface CustomDice<F> {
    val faces: Map<F, Pair<F, Double>>
}