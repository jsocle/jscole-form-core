package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class SingleValueField<T, N : Node>(protected val mapper: FieldMapper<T>, public val default: T = null) : Field<T, N>() {
    public var value: T = null
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
}