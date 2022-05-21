package com.example.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatProjectApplication.class, args);
	}
	
//	/**
//	 * CORS設定
//	 * 
//	 * @return CorsConfigurationSource
//	 */
//	@Bean
//	public CorsConfigurationSource corsFilter() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowCredentials(true);
//		configuration.addAllowedOrigin("http://localhost:8081");
//		configuration.addAllowedMethod(CorsConfiguration.ALL);
//		configuration.addAllowedHeader(CorsConfiguration.ALL);
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT"));
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//
//		return source;
//	}

}
