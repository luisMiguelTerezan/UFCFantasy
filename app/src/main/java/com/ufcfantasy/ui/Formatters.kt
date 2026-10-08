package com.ufcfantasy.ui

import java.text.NumberFormat
import java.util.Locale

private val ptBr = Locale("pt", "BR")

/** 1847 -> "1.847" */
fun Int.formatPoints(): String = NumberFormat.getIntegerInstance(ptBr).format(this)
