package com.rpgportugal.com.rpgportugal.dicegoblin.dice

interface ICustomDice<F> {
    val faces: Map<F, Pair<F, Double>>
}