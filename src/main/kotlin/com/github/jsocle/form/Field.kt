package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class Field<T : Any?, N : Node> {
    public val errors: MutableList<String> = arrayListOf()
    public abstract var value: T
    public val raw: Array<String> get() = information!!.form.parameters[name] ?: arrayOf()
    public val name: String get() = information!!.propertyMetadata.name
    public val form: Form get() = information!!.form

    protected var information: Information? = null

    fun initialize(form: Form, propertyMetadata: PropertyMetadata) {
        if (information == null) {
            information = Information(form, propertyMetadata)
            processParameters()
        }
    }

    public class Information(public val form: Form, public val propertyMetadata: PropertyMetadata)

    public abstract fun render(): N
    public abstract fun processParameters()
}

public fun <T : Field<*, *>> T.get(form: Form, propertyMetadata: PropertyMetadata): T {
    initialize(form, propertyMetadata)
    return this
}