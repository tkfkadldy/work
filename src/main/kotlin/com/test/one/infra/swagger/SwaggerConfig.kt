package com.test.one.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean

class SwaggerConfig {
    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .addSecurityItem(
            SecurityRequirement().addList("Bearer Authentication")
        )
        .components(
            Components().addSecuritySchemes(
                "Bearer Authentication",
                SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("Bearer")
                    .bearerFormat("JWT")
                    .`in`(SecurityScheme.In.HEADER)
                    .name("Authorization")
            )
        )
        .info(
            Info()
                .title("Work API")
                .description("Work API schema")
                .version("1.0.0")
        )
}