package com.github.jsocle.form

public abstract class Form(parameters: Map<String, Array<String>>? = null,
                           val trim: Boolean = true) {
    public val parameters: Map<String, Array<String>>

    init {
        this.parameters = parameters ?: request.parameters()
    }

    operator protected fun <T : Field<*, *>> T.get(form: Form, propertyMetadata: PropertyMetadata): T {
        initialize(form, propertyMetadata.name)
        return this
    }
}