package com.github.jsocle.form

public class IntFieldMapper : FieldMapper<Int?>() {
    override fun toString(value: Int?): String? = value?.toString()

    override fun fromString(field: Field<Int?, *>, string: String?): Int? {
        return try {
            string?.toInt()
        } catch(e: NumberFormatException) {
            field.errors.add("Not a valid integer value")
            null
        }
    }
}