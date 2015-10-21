package com.github.jsocle.form.fields

import com.github.jsocle.form.Field
import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Ul

open class CheckboxField<T : Any>(var choices: List<Pair<T, String>> = listOf(), mapper: FieldMapper<T>,
                                  defaults: List<T> = listOf(), validators: Array<Validator<T>> = arrayOf())
: Field<T, Ul>(mapper, defaults, validators = validators) {

    override fun render(): Ul {
        return Ul(class_ = "jsocle-form-field-checkbox") {
            choices.forEach {
                li {
                    label {
                        input(type = "checkbox", name = name, value = mapper.toString(it.first), checked = if (it.first in this@CheckboxField.values) "checked" else null)
                        +it.second
                    }
                }
            }
        }
    }
}