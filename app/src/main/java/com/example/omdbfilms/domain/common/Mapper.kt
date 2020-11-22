package com.example.omdbfilms.domain.common

interface Mapper<T, F> {

    fun map(from: T): F
}