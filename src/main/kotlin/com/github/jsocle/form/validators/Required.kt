package com.github.jsocle.form.validators

import com.github.jsocle.form.Field

class Required<T : Any> : Validator<T>() {
    override fun invoke(field: Field<T, *>) {
        if (field.raw.find { it.isNotBlank() } != null) {
            return
        }
        field.errors.add("This field is required.")
    }
}