package com.whoelse.domain.common

data class PageResponse<T>(
    val isLast: Boolean = true,

    val totalCnt: Long = 0,

    val contents: List<T> = emptyList()
)