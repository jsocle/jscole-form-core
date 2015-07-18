package com.github.jsocle.form

public abstract class Field {
    public val name: String
        get() = information!!.propertyMetadata.name

    private var information: Information? = null

    fun initialize(propertyMetadata: PropertyMetadata) {
        if (information == null) {
            information = Information(propertyMetadata)
        }
    }

    private class Information(val propertyMetadata: PropertyMetadata)
}

public fun <T : Field> T.get(form: Form, propertyMetadata: PropertyMetadata): T {
    initialize(propertyMetadata)
    return this
}