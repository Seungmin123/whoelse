package com.whoelse.domain.user.model.dto

import com.whoelse.domain.user.model.UserGrade

data class UserInfoReq(
    var nickName: String,

    var userGrade: UserGrade
) {
}