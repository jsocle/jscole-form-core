package com.github.jsocle.form

import org.junit.Assert
import org.junit.Test

public class IntFieldTest {
    public class TestForm(parameters: Map<String, Array<String>>) : Form(parameters) {
        val age by IntField()
    }

    Test public fun testValue() {
        val form = TestForm(parameters("age" to "23"))
        Assert.assertEquals(23, form.age.value)
    }

    Test public fun testNullValue() {
        val form = TestForm(parameters())
        Assert.assertNull(form.age.value)
    }
}