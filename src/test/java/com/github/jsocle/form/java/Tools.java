package com.github.jsocle.form.java;

import kotlin.Pair;

public class Tools {
    public static <K, V> Pair<K, V> pairOf(K k, V v) {
        return new Pair<>(k, v);
    }
}
