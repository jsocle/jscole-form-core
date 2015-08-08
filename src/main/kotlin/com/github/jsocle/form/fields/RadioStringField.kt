package com.github.jsocle.form.fields

import com.github.jsocle.form.StringFieldMapper

public class RadioStrinfField(choices: List<Pair<String, String>>) : RadioField<String?>(choices, StringFieldMapper()) {
}