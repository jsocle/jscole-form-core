package com.github.jsocle.form.fields

import com.github.jsocle.form.Field
import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Select

open class MultipleSelectField<T : Any>(var choices: List<Pair<T, String>>, defaults: List<T>, mapper: FieldMapper<T>,
                                        validators: Array<Validator<T>> = arrayOf())
: Field<T, Select>(mapper, defaults, validators = validators) {
    override fun render(): Select {
        return Select(name = name, multiple = "multiple") {
            choices.forEach {
                option(value = mapper.toString(it.first), text_ = it.second,
                        selected = if (it.first in values) "selected" else null)
            }
        }
    }
}