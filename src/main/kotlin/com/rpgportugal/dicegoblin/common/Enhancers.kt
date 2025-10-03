package com.rpgportugal.dicegoblin.common

import org.antlr.v4.runtime.tree.TerminalNode

fun TerminalNode.isEmpty() =
    this.text == null || this.text.isEmpty()