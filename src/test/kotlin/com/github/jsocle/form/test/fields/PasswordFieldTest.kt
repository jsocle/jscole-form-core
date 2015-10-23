package com.github.jsocle.form.test.fields

import com.github.jsocle.form.Form
import com.github.jsocle.form.fields.PasswordField
import com.github.jsocle.form.test.parameters
import com.github.jsocle.form.validators.Required
import org.junit.Assert
import org.junit.Test

class PasswordFieldTest {
    @Test
    fun testValidators() {
        parameters()
        val form = object : Form() {
            val password = PasswordField(validators = arrayOf(Required()))
        }
        form.validate()
        Assert.assertTrue(form.hasErrors)
        Assert.assertTrue(form.password.hasErrors)
    }
}

