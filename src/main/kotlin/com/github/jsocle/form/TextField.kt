package com.github.jsocle.form

public class TextField : Field<String?>() {
    override val value: String?
        get() = information!!.form.parameters[name]?.first()
}