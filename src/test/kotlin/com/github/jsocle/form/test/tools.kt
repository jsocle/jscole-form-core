package com.github.jsocle.form.test

import com.github.jsocle.form.request

object testRequest {
    val local = ThreadLocal<Map<String, Array<String>>>()

    var parameters: Map<String, Array<String>>
        get() = local.get()
        set(parameters: Map<String, Array<String>>) {
            local.set(parameters)
            request.parameters = { this.parameters }
        }
}

fun parameters(vararg parameters: Pair<String, String>) {
    testRequest.parameters = parameters.groupBy { it.first }.mapValues { it.value.map { it.second }.toTypedArray() }
}

