package com.github.jsocle.form

public abstract class FieldMapper<T : Any?> {
    public abstract fun fromString(string: String?): T
}