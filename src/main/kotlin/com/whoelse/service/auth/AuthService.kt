package com.whoelse.service.auth

import com.whoelse.domain.user.model.Gender
import com.whoelse.domain.user.model.User
import com.whoelse.domain.user.model.UserInfo
import com.whoelse.domain.user.model.dto.UserInfoReq
import com.whoelse.domain.user.repository.UserInfoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.util.ObjectUtils

@Service
class AuthService(
    private val userInfoRepository: UserInfoRepository
) {

    fun checkUserPreference(user: User): Boolean {
        var userInfo: UserInfo? = userInfoRepository.findByIdOrNull(user.id)
        return !ObjectUtils.isEmpty(userInfo)
    }

    fun setUserPreference(user: User, userInfoReq: UserInfoReq): UserInfo {
        return userInfoRepository.save(
            UserInfo(
                id = user.id,
                loginType = userInfoReq.loginType,
                grade = userInfoReq.userGrade,
                gender = Gender.UNKNOWN,
                age = -1,
                email = userInfoReq.email
            )
        )
    }

    // TODO Exception 처리
    fun getUserPreference(user: User): UserInfo {
        return userInfoRepository.findByIdOrNull(user.id) ?: throw Exception()
    }
}


//@Service
//class AuthService(
//    private val userRepository: UserRepository,
//    private val userInfoRepository: UserInfoRepository,
//    private val jwtService: JwtService,
//    private val socialLoginService: SocialLoginService
//) {
//    fun kakaoLogin(accessToken: String): AccessTokenAndRefreshToken {
//        val userId = socialLoginService.getKakaoUserInfo(accessToken).id
//        if (!isRegistered(userId)) {
//            register(userId, LoginType.KAKAO)
//        }
//        return jwtService.generateTokenByUserId(userId)
//    }
//
//    fun autoLogin(accessToken: String): AccessTokenAndRefreshToken {
//        val userId = jwtService.getUserIdFromToken(accessToken, TokenType.ACCESS)
//        return jwtService.generateTokenByUserId(userId)
//    }
//
//    fun refresh(refreshToken: String): AccessTokenAndRefreshToken {
//        val userId = jwtService.getUserIdFromToken(refreshToken, TokenType.REFRESH)
//        return jwtService.generateTokenByUserId(userId)
//    }
//
//    private fun isRegistered(userId: String) = userRepository.findByIdOrNull(userId) != null
//
//    fun register(userId: String, loginType: LoginType) {
//        userRepository.save(User(id = userId, loginType = loginType))
//    }
//
//    fun checkUserPreference(user: User): Boolean {
//        return userInfoRepository.findByIdOrNull(user.id) != null
//    }
//
//    fun setUserPreference(user: User, userInfoReq: UserInfoReq): UserInfo {
//        return userInfoRepository.save(
//            UserInfo(
//                id = user.id,
//                alcoholLevel = userInfoReq.alcoholLevel,
//                keyword = userInfoReq.keyword,
//                base = userInfoReq.base,
//                weightLevel = userInfoReq.weightBase,
//                weightBase = userInfoReq.weightBase,
//                weightKeyword = userInfoReq.weightKeyword,
//            )
//        )
//    }
//
//    fun getUserPreference(user: User): UserInfo {
//        return userInfoRepository.findByIdOrNull(user.id) ?: throw BaseException(CommonErrorCode.NOT_EXIST_USER)
//    }
//
//}