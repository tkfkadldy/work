package com.test.one.infra.security.jwt

import com.test.one.infra.security.UserPrincipal
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.core.annotation.Order
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtPlugin: JwtPlugin
): OncePerRequestFilter() {

    companion object{
        private val BEARER_PATTERN = Regex("^Bearer(.+?)$") //정규식
    }

    fun getBearerToken(authorization : String) : String? {
        if (authorization == null)
            return null

        return try{
            val matchResult = BEARER_PATTERN.find(authorization)
            matchResult?.groupValues?.get(1)
        } catch (e:Exception){
            null
        }
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val jwt = parseBearerToken(request)
        jwt?.apply {
            jwtPlugin.validateToken(jwt)
                .onSuccess {
                    val userId = it.payload.subject.toLong()
                    val role = it.payload.get("role", String::class.java)
                    val email = it.payload.get("email", String::class.java)

                    val principal = UserPrincipal(
                        id = userId,
                        email = email,
                        role = setOf(role)
                    )
                    val authentication = JwtAuthenticationToken(
                        principal = principal,
                        details = WebAuthenticationDetailsSource().buildDetails(request)
                    )
                    SecurityContextHolder.getContext().authentication = authentication
                }
        }
        filterChain.doFilter(request, response)
    }

    private fun parseBearerToken(request: HttpServletRequest) = request.getHeader(HttpHeaders.AUTHORIZATION)
        .takeIf { it?.startsWith("Bearer ", true) ?: false }?.substring(7)
    private fun parseUserSpecification(token: String?) =(
            token?.takeIf { it.length >= 10 }
                ?.let{jwtPlugin.validateToken(token)}
            )
}