package com.whoelse.web

import com.whoelse.domain.common.CommonResponse
import com.whoelse.domain.user.model.User
import com.whoelse.domain.user.model.UserInfo
import com.whoelse.domain.user.model.dto.UserInfoReq
import com.whoelse.service.auth.AuthService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*


@RequestMapping("/user")
@RestController
class UserController(
    private val authService: AuthService
) {

    @GetMapping("/health")
    fun userHealthCheck(): String {
        return "OK"
    }

    /**
     * UserInfo 있는지 조회
     */
    @GetMapping("/check-preference")
    fun checkUserPreference(
        @AuthenticationPrincipal user: User
    ): CommonResponse<Boolean> {
        return CommonResponse.onSuccess(authService.checkUserPreference(user))
    }

    /**
     * 유저 정보 Upsert
     */
    @PostMapping("/preference")
    fun setUserPreference(
        @AuthenticationPrincipal user: User,
        @RequestBody userInfoReq: UserInfoReq
    ): CommonResponse<UserInfo> {
        return CommonResponse.onSuccess(authService.setUserPreference(user, userInfoReq))
    }

    /**
     * 유저 정보 조회
     */
    @GetMapping("/preference")
    fun getUserPreference(
        @AuthenticationPrincipal user: User
    ): CommonResponse<UserInfo> {
        return CommonResponse.onSuccess(authService.getUserPreference(user))
    }
}