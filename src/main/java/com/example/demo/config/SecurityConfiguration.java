package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity // replace of enable global security annptation
public class SecurityConfiguration {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		// for create in memory user
		/*
		 * UserDetails admin = User.withUsername("axay")
		 * .password(passwordEncoder.encode("1234")) .roles("ADMIN") .build();
		 * 
		 * return new InMemoryUserDetailsManager(admin);
		 */

		return new UserInfoUserDetailsService();
	}

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .csrf().disable()
	                .authorizeRequests()
	                    .requestMatchers("/register").permitAll()
	                    .requestMatchers("/dashboard/**").authenticated()
	                    .and()
	                .formLogin()
	                    .loginPage("/login")
	                    .loginProcessingUrl("/processLogin")
	                    .defaultSuccessUrl("/dashboard")
	                    .and()
	                .build();
	    }

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
