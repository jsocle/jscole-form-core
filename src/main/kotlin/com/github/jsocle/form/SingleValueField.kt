package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class SingleValueField<T : Any?, N : Node>(mapper: FieldMapper<T>, public val default: T = null) :
        Field<T, N>(mapper, default.toList()) {
    public var value: T
        get() {
            // values.firstOrNull() dose not work
            if (values.size() == 0) {
                return null
            }
            return values.first()
        }
        set(value: T) {
            values = value.toList()
        }
}

private fun <T : Any?> T.toList(): List<T> {
    return if (this == null) listOf() else listOf(this)
}