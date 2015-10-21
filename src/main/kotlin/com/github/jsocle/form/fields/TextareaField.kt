package com.github.jsocle.form.fields

import com.github.jsocle.form.SingleValueField
import com.github.jsocle.form.StringFieldMapper
import com.github.jsocle.form.validators.Validator
import com.github.jsocle.html.elements.Textarea

class TextareaField(default: String? = null, validators: Array<Validator<String>> = arrayOf())
: SingleValueField<String, Textarea>(StringFieldMapper(), default, validators = validators) {
    override fun render(): Textarea {
        return Textarea(name = name, text_ = raw.firstOrNull())
    }
}