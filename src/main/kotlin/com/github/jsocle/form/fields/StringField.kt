package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper
import com.github.jsocle.form.validators.Validator

open class StringField(default: String? = null, validators: Array<Validator<String>> = arrayOf())
: InputField<String>(StringFieldMapper(), default, validators = validators)