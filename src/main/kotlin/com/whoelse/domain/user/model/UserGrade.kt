package com.whoelse.domain.user.model

enum class UserGrade(
    val value: String,
    val grade: String
) {
    GRADE_BRONZE("GRADE_BRONZE", "1"),
    GRADE_SILVER("GRADE_SILVER", "2"),
    GRADE_GOLD("GRADE_GOLD", "3"),
    GRADE_PLATINUM("GRADE_PLATINUM", "4"),
    GRADE_DIAMOND("GRADE_DIAMOND", "5");
}