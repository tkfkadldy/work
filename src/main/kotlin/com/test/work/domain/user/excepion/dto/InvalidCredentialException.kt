package com.test.work.domain.user.excepion.dto

data class InvalidCredentialException(
    override val message: String? = "The credential is invalid"
) : RuntimeException()
