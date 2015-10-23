package com.github.jsocle.form.fields

import com.github.jsocle.form.fieldMappers.StringFieldMapper

class SelectStringField(choices: List<Pair<String, String>> = listOf(), default: String? = null)
: SelectField<String>(choices, StringFieldMapper(), default) {
}