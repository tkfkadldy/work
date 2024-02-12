package com.test.one.infra.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.sql.Timestamp
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@Component
class JwtPlugin(
    @Value("\${jwt.secret-key}")
    private val secretKey: String,
    @Value("\${jwt.issuer}")
    private val issuer: String,
    @Value("\${jwt.expiration-hours}")
    private val expirationHours: Long,
) {
    fun validateToken(jwt: String): Result<Jws<Claims>>
    {
        return kotlin.runCatching {
            val key = Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8))
            Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt)
        }
    }

    fun generateToken(subject: String, email: String, role: String) =
        Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(secretKey.toByteArray(StandardCharsets.UTF_8)))
            .subject(subject)
            .issuer(issuer)
            .expiration((Date.from(Instant.now().plus(Duration.ofHours(expirationHours)))))
            .issuedAt(Timestamp.valueOf(LocalDateTime.now()))
            .claims(Jwts.claims().add(mapOf("role" to role, "email" to email)).build())
            .compact()!!
}