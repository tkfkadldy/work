package com.test.one.infra.security

import com.test.one.infra.security.jwt.JwtAuthenticationFilter
import com.test.one.infra.security.jwt.JwtAuthenticationToken
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic { it.disable() }
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/login",
                    "/signup",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                ).permitAll()
                    // 위 URI를 제외하곤 모두 인증이 되어야 함.
                    .anyRequest().authenticated()
            }
            // 기존 UsernamePasswordAuthenticationFilter 가 존재하던 자리에 JwtAuthenticationFilter 적용
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }

}