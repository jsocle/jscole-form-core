package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper

open class StringField(default: String? = null)
: InputField<String>(StringFieldMapper(), default)