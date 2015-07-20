package com.github.jsocle.form

public class StringFieldMapper : FieldMapper<String?>() {
    override fun fromString(field: Field<String?, *>, string: String?): String? = string
}