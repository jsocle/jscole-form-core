package com.github.jsocle.form.fields

import com.github.jsocle.form.FieldMapper
import com.github.jsocle.form.SingleValueField
import com.github.jsocle.html.elements.Input

public open class InputField<T>(mapper: FieldMapper<T?>, default: T? = null) : SingleValueField<T?, Input>(mapper, default) {
    override fun render(): Input {
        return Input(type = "text", name = name, value = raw.firstOrNull())
    }
}