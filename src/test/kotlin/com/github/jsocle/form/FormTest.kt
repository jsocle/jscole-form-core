package com.github.jsocle.form

import com.github.jsocle.html.elements.Input
import org.junit.Assert
import org.junit.Test

public class FormTest {
    Test public fun test() {
        class TestForm(parameters: Map<String, Array<String>>) : Form(parameters) {
            val firstName by TextField()
            val lastName by TextField()
        }

        val form = TestForm(parameters("firstName" to "john"))

        Assert.assertEquals("firstName", form.firstName.name)
        Assert.assertArrayEquals(arrayOf("john"), form.firstName.raw)
        Assert.assertEquals("john", form.firstName.value)
        Assert.assertEquals(Input(name = "firstName", type = "text", value = "john"), form.firstName.render())

        // test nullable data
        Assert.assertEquals("lastName", form.lastName.name)
        Assert.assertArrayEquals(arrayOf(), form.lastName.raw)
        Assert.assertNull(form.lastName.value)
        Assert.assertEquals(Input(name = "lastName", type = "text"), form.lastName.render())
    }
}