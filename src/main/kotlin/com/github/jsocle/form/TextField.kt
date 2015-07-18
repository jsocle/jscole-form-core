package com.github.jsocle.form

import com.github.jsocle.html.elements.Input

public class TextField : Field<String?, Input>() {
    override fun render(): Input = Input(type = "text", name = name, value = value)

    override val value: String?
        get() = information!!.form.parameters[name]?.first()
}