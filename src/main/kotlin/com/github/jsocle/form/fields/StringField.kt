package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper
import com.github.jsocle.form.fields.InputField

public open class StringField(default: String? = null) : InputField<String?>(StringFieldMapper(), default)