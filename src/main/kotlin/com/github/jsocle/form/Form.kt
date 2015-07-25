package com.github.jsocle.form

import com.github.jsocle.form.request

public abstract class Form {
    public val parameters: Map<String, Array<String>>

    init {
        parameters = request.parameters()
    }
}