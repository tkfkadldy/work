package com.test.work.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class SwaggerConfig {
    @Configuration
    class SwaggerConfig {

        @Bean
        fun openAPI(): OpenAPI = OpenAPI()
            .components(Components())
            .info(
                Info()
                    .title("work API")
                    .description("work API schema")
                    .version("1.0.0")
            )
    }
}