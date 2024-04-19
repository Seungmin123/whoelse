package com.whoelse.config.security.jwt

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.SecurityConfigurer
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class JwtSecurityConfig(
    private val jwtService: JwtService
) :
    SecurityConfigurer<DefaultSecurityFilterChain?, HttpSecurity> {

    override fun init(builder: HttpSecurity?) {
    }
    override fun configure(http: HttpSecurity) {
        val customFilter = JwtFilter(jwtService)
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter::class.java)
    }

}