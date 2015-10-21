package com.github.jsocle.form.fields

import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.SingleValueField
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Select

open class SelectField<T : Any>(var choices: List<Pair<T, String>>, mapper: FieldMapper<T>, default: T? = null,
                                validators: Array<Validator<T>> = arrayOf())
: SingleValueField<T, Select>(mapper, default, validators = validators) {
    override fun render(): Select {
        return Select(name = name) {
            choices.forEach {
                option(
                        value = mapper.toString(it.first), text_ = it.second,
                        selected = if (it.first == value) "selected" else null
                )
            }
        }
    }
}