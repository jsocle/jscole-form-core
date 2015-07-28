package com.github.jsocle.form

public abstract class Form(parameters: Map<String, Array<String>>? = null) {
    public val parameters: Map<String, Array<String>>

    init {
        this.parameters = parameters ?: request.parameters()
    }
}