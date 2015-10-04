package com.github.jsocle.form

import com.github.jsocle.html.Node

public abstract class Field<T : Any?, N : Node>(protected val mapper: FieldMapper<T>,
                                                public val defaults: List<T>) {
    public val errors: MutableList<String> = arrayListOf()
    private var _values: List<T> = listOf()
    public var values: List<T>
        get() = _values
        set(values: List<T>) {
            rawFromValues = true
            _values = values
        }
    private var rawFromValues = false
    private var _raw: Array<String> = arrayOf()
    public val raw: Array<String>
        get() {
            if (!rawFromValues) {
                return _raw
            }
            return values.map { mapper.toString(it) }.filter { it != null }.map { it!! }.toTypedArray()
        }

    public var name: String = ""
        private set
    public var form: Form? = null
        private set

    fun initialize(form: Form, propertyMetadata: PropertyMetadata) {
        if (this.form == null) {
            this.form = form;
            this.name = propertyMetadata.name

            if (form.parameters.size() == 0) {
                values = defaults
            } else {
                _raw = form.parameters[name] ?: arrayOf()
                _values = _raw.map { mapper.fromString(this, it) }.filter { it != null }
            }
        }
    }

    public abstract fun render(): N

    public fun render(map: N.() -> Unit): N {
        val node = render()
        node.map()
        return node
    }
}
