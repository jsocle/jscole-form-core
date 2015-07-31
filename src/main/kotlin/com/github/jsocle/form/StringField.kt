package com.github.jsocle.form

public open class StringField(default: String? = null) : InputField<String?>(StringFieldMapper(), default)