package com.github.jsocle.form.fields

import com.github.jsocle.form.BooleanMapper
import com.github.jsocle.form.SingleValueField
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Input

class BooleanField(validators: Array<Validator<Boolean>> = arrayOf()) : SingleValueField<Boolean, Input>(BooleanMapper(), validators = validators) {
    override fun render(): Input {
        return Input(name = name, type = "checkbox", value = "true", checked = if (value ?: false) "checked" else null)
    }
}