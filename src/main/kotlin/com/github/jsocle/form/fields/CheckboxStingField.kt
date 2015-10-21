package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper

public class CheckboxStingField(choices: List<Pair<String, String>>, defaults: List<String> = listOf()) :
        CheckboxField<String>(choices, StringFieldMapper(), defaults) {
}