package com.github.jsocle.form

import org.junit.Assert
import org.junit.Test

public class FormTest {
    Test public fun test() {
        class TestForm(parameters: Map<String, Array<String>>) : Form(parameters) {
            val name by TextField()
        }

        val form = TestForm(parameters("name" to "john"))

        Assert.assertEquals("name", form.name.name)
        Assert.assertArrayEquals(arrayOf("john"), form.name.raw)
    }
}