package com.github.jsocle.form

import com.github.jsocle.html.elements.Input

public class BooleanField : SingleValueField<Boolean?, Input>(BooleanMapper()) {
    override fun render(): Input {
        return Input(name = name, type = "checkbox", value = "true", checked = if (value ?: false) "checked" else null)
    }
}