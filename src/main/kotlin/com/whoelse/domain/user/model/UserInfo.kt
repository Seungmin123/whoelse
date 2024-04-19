package com.whoelse.domain.user.model

import jakarta.persistence.*

@Entity(name = "user_info")
data class UserInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    val grade: UserGrade = UserGrade.GRADE_BRONZE

)