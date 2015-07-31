package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class Field<T : Any?, N : Node> {
    public val errors: MutableList<String> = arrayListOf()
    public var raw: Array<String> = arrayOf()
        protected set
    public val name: String get() = information!!.propertyMetadata.name
    public val form: Form get() = information!!.form

    protected var information: Information? = null

    fun initialize(form: Form, propertyMetadata: PropertyMetadata) {
        if (information == null) {
            information = Information(form, propertyMetadata)
            raw = information!!.form.parameters[name] ?: arrayOf()
            processParameters()
        }
    }

    public class Information(public val form: Form, public val propertyMetadata: PropertyMetadata)

    public abstract fun render(): N
    public fun render(map: N.() -> Unit): N {
        val node = render()
        node.map()
        return node
    }

    public abstract fun processParameters()
}
