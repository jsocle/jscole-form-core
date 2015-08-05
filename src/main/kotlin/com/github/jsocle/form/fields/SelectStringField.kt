package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper
import com.github.jsocle.form.fields.SelectField

public class SelectStringField(choices: List<Pair<String, String>> = listOf(), default: String? = null) :
        SelectField<String?>(choices, StringFieldMapper(), default) {
}