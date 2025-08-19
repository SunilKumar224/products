package com.ecommerce.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce Products API")
                        .description("API documentation for E-commerce project products module")
                        .version("1.0.0"));
    }
	
	//we need to allow swagger when using spring security
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
	            .anyRequest().authenticated()
	        );
	    return http.build();
	} */

}
