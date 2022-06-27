package com.example.chat;

import java.util.Arrays;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.chat.model.ErrorResponse;
import com.example.chat.util.MessageCode;

/**
 * セキュリティ設定
 *
 * @author tk
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** ユーザー詳細サービス */
	private final UserDetailsService userDetailsService;

	/** HTTPメッセージコンバーター */
	private final MappingJackson2HttpMessageConverter httpMessageConverter;

	/** メッセージソース */
	private MessageSource messageSource;

	/**
	 * コンストラクタ
	 * 
	 * @param userDetailsService   ユーザー詳細サービス
	 * @param httpMessageConverter HTTPメッセージコンバーター
	 * @param messageSource        メッセージソース
	 */
	public SecurityConfig(UserDetailsService userDetailsService,
			MappingJackson2HttpMessageConverter httpMessageConverter, MessageSource messageSource) {
		this.userDetailsService = userDetailsService;
		this.httpMessageConverter = httpMessageConverter;
		this.messageSource = messageSource;
	}

	/**
	 * パスワードエンコーダー生成
	 * 
	 * @return パスワードエンコーダー
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/signup");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// ログイン処理の設定
		http.formLogin().loginProcessingUrl("/login")// ログイン処理
				.successHandler(successHandler())// 認証成功時の処理
				.failureHandler(failureHandler())// 認証失敗時の処理
				.usernameParameter("userId")// ユーザー名の項目名
				.passwordParameter("password")// パスワードの項目名
				.permitAll();

		// ログアウトの処理
		http.logout().logoutUrl("/logout")// ログアウト処理
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler());

		// 権限の設定
		http.authorizeRequests().antMatchers("/admin")// 制限をかける処理
				.hasRole("000")// ADMIN権限のみ"/admin"にアクセス可能
				.anyRequest().authenticated();

		// 未認証時の設定
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());

		// CSRF設定
		http.csrf().disable();

		// CORS対策
		http.cors().configurationSource(this.corsFilter());

	}

	/**
	 * 認証成功ハンドラー
	 * 
	 * @return AuthenticationSuccessHandler
	 */
	private AuthenticationSuccessHandler successHandler() {
		return (request, response, auth) -> {
			if (response.isCommitted()) {
				return;
			}
			response.setStatus(HttpStatus.OK.value());
		};
	}

	/**
	 * 認証失敗ハンドラー
	 * 
	 * @return AuthenticationFailureHandler
	 */
	private AuthenticationFailureHandler failureHandler() {

		return (request, response, exception) -> {
			if (exception instanceof InternalAuthenticationServiceException) {
				throw exception;
			}

			ErrorResponse result = new ErrorResponse();
			result.setMessages(Arrays
					.asList(messageSource.getMessage(MessageCode.AUTHENTICATION_FAILURE, null, request.getLocale())));
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
			httpMessageConverter.write(result, MediaType.APPLICATION_JSON, outputMessage);

		};
	}

	/**
	 * 未認証ハンドラー
	 * 
	 * @return AuthenticationEntryPoint
	 */
	private AuthenticationEntryPoint authenticationEntryPoint() {

		return (request, response, exception) -> {
			ErrorResponse result = new ErrorResponse();
			result.setMessages(
					Arrays.asList(messageSource.getMessage(MessageCode.UNAUTHENTICATION, null, request.getLocale())));
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
			httpMessageConverter.write(result, MediaType.APPLICATION_JSON, outputMessage);
		};
	}

	/**
	 * ログアウトハンドラー
	 * 
	 * @return HttpStatusReturningLogoutSuccessHandler
	 */
	private LogoutSuccessHandler logoutSuccessHandler() {
		return new HttpStatusReturningLogoutSuccessHandler();
	}

	/**
	 * CORS設定
	 * 
	 * @return CorsConfigurationSource
	 */
	private CorsConfigurationSource corsFilter() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOrigin("http://localhost:8081/");
		configuration.addAllowedMethod(CorsConfiguration.ALL);
		configuration.addAllowedHeader(CorsConfiguration.ALL);
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);

		return source;
	}

}
