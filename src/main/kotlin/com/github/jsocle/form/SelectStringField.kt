package com.github.jsocle.form

public class SelectStringField(choices: List<Pair<String, String>> = listOf(), default: String? = null) :
        SelectField<String?>(choices, StringFieldMapper(), default) {
}