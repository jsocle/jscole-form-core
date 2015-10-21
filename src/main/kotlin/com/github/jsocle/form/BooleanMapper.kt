package com.github.jsocle.form

public class BooleanMapper : FieldMapper<Boolean>() {
    override fun toString(value: Boolean?): String? {
        return value?.toString()
    }

    override fun fromString(field: Field<Boolean, *>, string: String?): Boolean? {
        return string?.toBoolean()
    }
}