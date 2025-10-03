package com.rpgportugal.dicegoblin.expressions.modifiers

class ModifierFactory {
    val modifierConstructors = listOf(::KeepHighestModifier)

    fun getModifier(modifier:String?): Modifier? {
        if(modifier.isNullOrBlank()) return null
        return modifierConstructors.map { it(modifier) }.find { it.getIdentifier().matches(modifier) }
    }
}