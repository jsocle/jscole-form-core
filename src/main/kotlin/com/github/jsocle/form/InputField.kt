package com.github.jsocle.form

import com.github.jsocle.html.elements.Input

public open class InputField<T>(private val mapper: FieldMapper<T>) : Field<T, Input>() {
    override val value: T
        get() = mapper.fromString(raw.firstOrNull())

    override fun render(): Input {
        return Input(type = "text", name = name, value = raw.firstOrNull())
    }
}