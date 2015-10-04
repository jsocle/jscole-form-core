package com.github.jsocle.form.java;

import com.github.jsocle.form.Form;
import com.github.jsocle.form.fields.StringField;
import com.github.jsocle.form.test.ToolsKt;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FormTest {
    @Test
    public void test() {
        class TestForm extends Form {
            public final StringField id = new StringField();
        }

        ToolsKt.parameters();
        final TestForm form = new TestForm();
        assertEquals("id", form.id.getName());
    }
}