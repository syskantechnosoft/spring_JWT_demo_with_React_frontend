package com.syskan.authservice.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Profile("dev")
@Configuration(proxyBeanMethods = false)
public class DevProfileSecurityConfig {

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher(PathRequest.toH2Console());
		http.authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
		http.csrf((csrf) -> csrf.disable());
		http.headers((headers) -> headers.frameOptions().sameOrigin());
		return http.build();
	}

//	 @Bean
//	    @Order(Ordered.HIGHEST_PRECEDENCE)
//	    public SecurityFilterChain h2ConsoleSecurityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .securityMatcher(new AntPathRequestMatcher("/h2-console/**"))
//	            .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
//	            .csrf(AbstractHttpConfigurer::disable)
//	            .headers(headers -> headers.frameOptions().sameOrigin());
//	        return http.build();
//	    }

//	@Bean
//	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(
//				authorize -> authorize.requestMatchers("/public/**").permitAll().anyRequest().authenticated())
//				.formLogin(withDefaults()).httpBasic(withDefaults());
//		return http.build();
//	}
//
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
//				.username("user").password("password").roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/h2-console/**");
	}
}
