package com.github.jsocle.form.fields

import com.github.jsocle.form.IntFieldMapper
import com.github.jsocle.form.fields.InputField

public class IntField(default: Int? = null) : InputField<Int?>(IntFieldMapper(), default)