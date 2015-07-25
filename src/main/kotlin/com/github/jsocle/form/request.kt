package com.github.jsocle.form

public object request {
    public var parameters: () -> Map<String, Array<String>> = {
        throw IllegalArgumentException("com.github.jsocle.form.request parameters was not set.")
    }
        set
}