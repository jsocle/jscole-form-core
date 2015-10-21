package com.github.jsocle.form.fields

import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.SingleValueField
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Input

open class InputField<T : Any>(mapper: FieldMapper<T>, default: T? = null, validators: Array<Validator<T>> = arrayOf())
: SingleValueField<T, Input>(mapper, default, validators = validators) {
    override fun render(): Input {
        return Input(type = "text", name = name, value = raw.firstOrNull())
    }
}