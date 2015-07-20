package com.github.jsocle.form

import com.github.jsocle.html.elements.Input
import org.junit.Assert
import org.junit.Test

public class FormTest {
    Test public fun test() {
        class TestForm(parameters: Map<String, Array<String>>) : Form(parameters) {
            val firstName by StringField()
            val lastName by StringField()
            val age by IntField()
            val page by IntField(0)
            val birthYear by IntField()
        }

        val form = TestForm(parameters("firstName" to "john", "age" to "31", "birthYear" to "1980s"))

        Assert.assertEquals("firstName", form.firstName.name)
        Assert.assertArrayEquals(arrayOf("john"), form.firstName.raw)
        Assert.assertEquals("john", form.firstName.value)
        Assert.assertEquals(Input(name = "firstName", type = "text", value = "john"), form.firstName.render())

        // test nullable data
        Assert.assertEquals("lastName", form.lastName.name)
        Assert.assertArrayEquals(arrayOf(), form.lastName.raw)
        Assert.assertNull(form.lastName.value)
        Assert.assertEquals(Input(name = "lastName", type = "text"), form.lastName.render())

        // test integer field
        Assert.assertEquals("age", form.age.name)
        Assert.assertArrayEquals(arrayOf("31"), form.age.raw)
        Assert.assertEquals(31, form.age.value)
        Assert.assertEquals(Input(type = "text", name = "age", value = "31"), form.age.render())

        // test convert failed
        Assert.assertEquals(listOf("Not a valid integer value"), form.birthYear.errors)
        Assert.assertArrayEquals(arrayOf("1980s"), form.birthYear.raw)
        Assert.assertEquals(null, form.birthYear.value)

        // test default value was not applied.
        Assert.assertEquals(null, form.page.value)
        Assert.assertEquals(0, form.page.value ?: form.page.default)

        // test default value was applied.
        val defaultForm = TestForm(parameters())
        Assert.assertEquals(0, defaultForm.page.value)

    }
}