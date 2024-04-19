package com.whoelse.config.security

import com.whoelse.config.security.jwt.JwtAccessDeniedHandler
import com.whoelse.config.security.jwt.JwtAuthenticationEntryPoint
import com.whoelse.config.security.jwt.JwtSecurityConfig
import com.whoelse.config.security.jwt.JwtService
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
class SecurityConfig(
    private val jwtService: JwtService,
    private val jwtAccessDeniedHandler: JwtAccessDeniedHandler,
    private val jwtAuthenticationEntryPoint: JwtAuthenticationEntryPoint
) {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web ->
            web.ignoring()
                .requestMatchers(
                    "/h2-console/**",
                    "/favicon.ico",
                    "/swagger-ui/**",
                    "/swagger-resources/**",
                    "/api-docs/**",
                    "/v3/api-docs/**",
                    "/auth/**",
                    "/users/**", // TODO : 인가처리시 제외하기
                    "/health/**"
                )
        }
    }

    @Bean
    open fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .httpBasic { httpBasic: HttpBasicConfigurer<HttpSecurity> -> httpBasic.disable()}
            .csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable()}
            .formLogin { formLogin: FormLoginConfigurer<HttpSecurity> -> formLogin.disable() }
            .sessionManagement { session: SessionManagementConfigurer<HttpSecurity?> -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .headers { header ->
                header.frameOptions { it.sameOrigin() }
            }
            .exceptionHandling { exceptionHandling ->
                exceptionHandling
                    .accessDeniedHandler(jwtAccessDeniedHandler)
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
            }
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/**").permitAll()
                    .requestMatchers("/webjars/**", "/image/**").permitAll()
                    .requestMatchers("/profile").permitAll()
                    .requestMatchers("/favicon.ico").permitAll()
                    .requestMatchers("/swagger-ui/**").permitAll()
                    .requestMatchers("/login/**").permitAll()
                    .requestMatchers("/health/**").permitAll()
                    .requestMatchers("/test/**").permitAll()
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/")
                    .permitAll() // EB에서 HelathCheck를 "/"으로 함 200을 반환해야함
                    .requestMatchers("/admin/**").permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .apply(JwtSecurityConfig(jwtService))

        return http.build()
    }
}