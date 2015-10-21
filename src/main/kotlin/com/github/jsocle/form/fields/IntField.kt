package com.github.jsocle.form.fields

import com.github.jsocle.form.IntFieldMapper
import com.github.jsocle.form.validators.Validator

public class IntField(default: Int? = null, validators: Array<Validator<Int>> = arrayOf())
: InputField<Int>(IntFieldMapper(), default, validators = validators)