package com.whoelse.domain.user.model.dto

import com.whoelse.domain.user.model.LoginType
import com.whoelse.domain.user.model.UserGrade

data class UserInfoReq(
    var loginType: LoginType,

    var nickName: String,

    var userGrade: UserGrade,

    var email: String
) {
}