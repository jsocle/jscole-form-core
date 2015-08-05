package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class Field<T : Any?, N : Node>(protected val mapper: FieldMapper<T>,
                                                public val defaults: List<T> = listOf()) {
    public val errors: MutableList<String> = arrayListOf()
    public var values: List<T> = listOf()
        set(values: List<T>) {
            rawFromValues = true
            $values = values
        }
    private var rawFromValues = false
    public var raw: Array<String> = arrayOf()
        get() {
            if (!rawFromValues) {
                return $raw;
            }
            return values.map { mapper.toString(it) }.filter { it != null }.map { it!! }.toTypedArray()
        }
        protected set
    public val name: String get() = information!!.propertyMetadata.name
    public val form: Form get() = information!!.form

    protected var information: Information? = null

    fun initialize(form: Form, propertyMetadata: PropertyMetadata) {
        if (information == null) {
            information = Information(form, propertyMetadata)
            $raw = information!!.form.parameters[name] ?: arrayOf()

            if (form.parameters.size() == 0) {
                values = defaults
            } else {
                $values = $raw.map { mapper.fromString(this, it) }.filter { it != null }
            }
        }
    }

    public class Information(public val form: Form, public val propertyMetadata: PropertyMetadata)

    public abstract fun render(): N
    public fun render(map: N.() -> Unit): N {
        val node = render()
        node.map()
        return node
    }
}
