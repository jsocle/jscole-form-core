package com.github.jsocle.form.test

import com.github.jsocle.form.*
import com.github.jsocle.html.elements.Input
import org.junit.Assert
import org.junit.Test

public class FormTest {
    Test public fun test() {
        class TestForm : Form() {
            val firstName by StringField()
            val lastName by StringField()
            val age by IntField()
            val page by IntField(0)
            val birthYear by IntField()
            val content by TextareaField()
            val style by StringField()
            val checked by BooleanField()
            val notChecked by BooleanField()
        }

        parameters("firstName" to "john", "age" to "31", "birthYear" to "1980s", "content" to "<p>content</p>", "checked" to "true")
        val form = TestForm()

        Assert.assertEquals("firstName", form.firstName.name)
        Assert.assertArrayEquals(arrayOf("john"), form.firstName.raw)
        Assert.assertEquals("john", form.firstName.value)
        Assert.assertEquals(Input(name = "firstName", type = "text", value = "john"), form.firstName.render())
        // test value string setter
        form.firstName.value = "noah";
        Assert.assertEquals("noah", form.firstName.value)
        Assert.assertArrayEquals(arrayOf("noah"), form.firstName.raw)
        Assert.assertEquals(Input(name = "firstName", type = "text", value = "noah"), form.firstName.render())

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
        // test integer value setter
        form.age.value = 42
        Assert.assertEquals(42, form.age.value)
        Assert.assertArrayEquals(arrayOf("42"), form.age.raw)
        Assert.assertEquals(Input(type = "text", name = "age", value = "42"), form.age.render())

        // test convert failed
        Assert.assertEquals(listOf("Not a valid integer value"), form.birthYear.errors)
        Assert.assertArrayEquals(arrayOf("1980s"), form.birthYear.raw)
        Assert.assertEquals(null, form.birthYear.value)
        Assert.assertEquals(Input(type = "text", name = "birthYear", value = "1980s"), form.birthYear.render())
        // test integer value setter when user input wrong values
        form.birthYear.value = 1980
        Assert.assertArrayEquals(arrayOf("1980"), form.birthYear.raw)
        Assert.assertEquals(1980, form.birthYear.value)
        Assert.assertEquals(Input(type = "text", name = "birthYear", value = "1980"), form.birthYear.render())

        // test default value was not applied.
        Assert.assertEquals(null, form.page.value)
        Assert.assertEquals(0, form.page.value ?: form.page.default)


        // test textarea
        Assert.assertEquals("<p>content</p>", form.content.value)
        Assert.assertEquals("""<textarea name="content">&lt;p&gt;content&lt;/p&gt;</textarea>""", form.content.render().toString())

        Assert.assertEquals(
                Input(name = "style", type = "text", style = "display: none;"),
                form.style.render { style = "display: none;" }
        )

        // test boolean
        Assert.assertTrue(form.checked.value ?: false)
        Assert.assertEquals(
                Input(name = "checked", type = "checkbox", value = "true", checked = "checked"), form.checked.render()
        )
        Assert.assertFalse(form.notChecked.value ?: false)
        Assert.assertEquals(Input(name = "notChecked", type = "checkbox", value = "true"), form.notChecked.render())

        // test default value was applied.
        parameters()
        val defaultForm = TestForm()
        Assert.assertEquals(0, defaultForm.page.value)
    }
}