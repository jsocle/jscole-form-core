package com.github.jsocle.form.fields

import com.github.jsocle.form.Field
import com.github.jsocle.form.FieldMapper
import com.github.jsocle.html.elements.Select

public open class MultipleSelectField<T : Any?>(public var choices: List<Pair<T, String>>, defaults: List<T>, mapper: FieldMapper<T>) :
        Field<T, Select>(mapper, defaults) {
    override fun render(): Select {
        return Select(name = name, multiple = "true") {
            choices.forEach {
                option(value = mapper.toString(it.first), text_ = it.second,
                        selected = if (it.first in values) "selected" else null)
            }
        }
    }
}