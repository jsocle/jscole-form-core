package com.github.jsocle.form.fields

import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Input

public class PasswordField(validators: Array<Validator<String>> = arrayOf()) : StringField(validators = validators) {
    override fun render(): Input {
        return Input(name = name, type = "password")
    }
}