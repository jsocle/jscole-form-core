package com.github.jsocle.form

public class StringFieldMapper : FieldMapper<String>() {
    override fun toString(value: String?): String? = value

    override fun fromString(field: Field<String, *>, string: String?): String? =
            if (string != null && field.form!!.trim) string.trim() else string
}