package com.github.jsocle.form.fields

import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.SingleValueField
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Ul

public open class RadioField<T : Any>(public var choices: List<Pair<T, String>>, mapper: FieldMapper<T>,
                                      validators: Array<Validator<T>> = arrayOf()) :
        SingleValueField<T, Ul>(mapper, validators = validators) {
    override fun render(): Ul {
        return Ul(class_ = "jsocle-form-field-radio") {
            choices.forEach {
                li {
                    label {
                        val checked = if (it.first == this@RadioField.value) "checked" else null
                        input(name = name, type = "radio", value = mapper.toString(it.first), checked = checked)
                        +it.second
                    }
                }
            }
        }
    }
}