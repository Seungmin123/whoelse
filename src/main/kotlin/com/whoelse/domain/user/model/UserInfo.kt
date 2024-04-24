package com.whoelse.domain.user.model

import jakarta.persistence.*

@Entity(name = "user_info")
data class UserInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "login_type")
    val loginType: LoginType,

    @Column(name = "grade", nullable = false)
    var grade: UserGrade = UserGrade.GRADE_BRONZE,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    var gender: Gender = Gender.UNKNOWN,

    @Column(name = "age")
    var age: Int = -1,

    @Column(name = "email")
    var email: String

)