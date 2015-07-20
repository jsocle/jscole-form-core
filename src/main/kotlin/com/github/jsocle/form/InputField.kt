package com.github.jsocle.form

import com.github.jsocle.html.elements.Input

public open class InputField<T>(private val mapper: FieldMapper<T>, public val default: T = null) : Field<T, Input>() {
    override val value: T
        get() = if (form.parameters.size() == 0) default else mapper.fromString(raw.firstOrNull())

    override fun render(): Input {
        return Input(type = "text", name = name, value = raw.firstOrNull())
    }
}