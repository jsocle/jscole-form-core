package com.github.jsocle.form

import com.github.jsocle.html.elements.Input

public open class InputField<T>(private val mapper: FieldMapper<T>, public val default: T = null) : Field<T, Input>() {
    override var value: T = null
        set(value: T) {
            $value = value
            val stringValue = mapper.toString(value)
            raw = if (stringValue != null) arrayOf(stringValue) else arrayOf()
        }

    override fun processParameters() {
        if (form.parameters.size() == 0) {
            value = default
        } else {
            $value = mapper.fromString(this, raw.firstOrNull())
        }
    }

    override fun render(): Input {
        return Input(type = "text", name = name, value = raw.firstOrNull())
    }
}