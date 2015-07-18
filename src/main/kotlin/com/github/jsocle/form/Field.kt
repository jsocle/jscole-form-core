package com.github.jsocle.form

public abstract class Field {
    val raw: Array<String> get() = information!!.form.parameters[name] ?: arrayOf()

    public val name: String get() = information!!.propertyMetadata.name

    private var information: Information? = null

    fun initialize(form: Form, propertyMetadata: PropertyMetadata) {
        if (information == null) {
            information = Information(form, propertyMetadata)
        }
    }

    private class Information(val form: Form, val propertyMetadata: PropertyMetadata)
}

public fun <T : Field> T.get(form: Form, propertyMetadata: PropertyMetadata): T {
    initialize(form, propertyMetadata)
    return this
}