package com.github.jsocle.form

public class IntFieldMapper : FieldMapper<Int?>() {
    override fun fromString(string: String?): Int? {
        return try {
            string?.toInt()
        } catch(e: NumberFormatException) {
            null
        }
    }
}