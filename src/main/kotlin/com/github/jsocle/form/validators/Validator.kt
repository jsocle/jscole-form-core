package com.github.jsocle.form.validators

import com.github.jsocle.form.Field

abstract class Validator<T : Any> {
    operator abstract fun invoke(field: Field<T, *>)
}