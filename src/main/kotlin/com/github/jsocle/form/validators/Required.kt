package com.github.jsocle.form.validators

import com.github.jsocle.form.Field

class Required : (Field<*, *>) -> Unit {
    operator override fun invoke(field: Field<*, *>) {
        if (field.raw.find { it.isNotBlank() } != null) {
            return
        }
        field.errors.add("This field is required.")
    }
}