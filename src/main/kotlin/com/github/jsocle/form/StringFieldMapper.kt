package com.github.jsocle.form

public class StringFieldMapper : FieldMapper<String?>() {
    override fun fromString(string: String?): String? = string
}