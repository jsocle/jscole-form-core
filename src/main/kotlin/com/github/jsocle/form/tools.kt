package com.github.jsocle.form

fun parameters(vararg parameters: Pair<String, String>) = parameters.map { it.first to arrayOf(it.second) }.toMap()

