package com.example.domain.common

interface Mapper<T, F> {

    fun map(from: T): F
}