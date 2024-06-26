package com.whoelse.config.security.jwt

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component

@Component
class JwtAccessDeniedHandler : AccessDeniedHandler {

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: org.springframework.security.access.AccessDeniedException
    ) {
        // 필요한 권한이 없이 접근하려 할때 403
        val errorCode =  "not allowed access"// UserAuthErrorCode.NOT_ALLOWED_ACCESS
        response.contentType = "application/json;charset=UTF-8"
        response.characterEncoding = "utf-8"
        response.status = HttpServletResponse.SC_UNAUTHORIZED
    }
}