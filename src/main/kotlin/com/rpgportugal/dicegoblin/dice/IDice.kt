package com.rpgportugal.com.rpgportugal.dicegoblin.dice

import com.rpgportugal.com.rpgportugal.dicegoblin.dice.faces.IFace

interface IDice {
    fun getFaces(): Map<IFace, Double>
}