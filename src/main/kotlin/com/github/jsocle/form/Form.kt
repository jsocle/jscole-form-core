package com.github.jsocle.form

public abstract class Form(parameters: Map<String, Array<String>>? = null,
                           val trim: Boolean = true) {
    val fields: Array<Field<*, *>> by lazy(LazyThreadSafetyMode.NONE) {
        javaClass.methods
                .filter { it.name.startsWith("get") && it.name.length() > 3 }
                .filter { Field::class.java.isAssignableFrom(it.returnType) }
                .map { it(this@Form) as Field<*, *> }
                .toTypedArray()
    }

    val errors: Array<String>
        get() = fields.flatMap { it.errors }.toTypedArray()

    public val parameters: Map<String, Array<String>>

    init {
        this.parameters = parameters ?: request.parameters()
    }

    operator protected fun <T : Field<*, *>> T.get(form: Form, propertyMetadata: PropertyMetadata): T {
        initialize(form, propertyMetadata.name)
        return this
    }

    fun validateOnPost(): Boolean {
        if (request.method() != "POST") {
            return false
        }
        return validate()
    }

    open fun validate(): Boolean {
        fields.forEach { it.validate() }
        return errors.isEmpty()
    }
}