package com.rpgportugal.dicegoblin.parser

import com.rpgportugal.dicegoblin.expression.Expression

interface ContextParser {

    fun parse() : Expression

}