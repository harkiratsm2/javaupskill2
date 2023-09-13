package com.hcl.surabirestaurant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.hcl.surabirestaurant.serviceImpl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().antMatchers("/MenuCRUD/**", "/UserCRUD/**", "/CustomerSales/**")
				.hasRole("ADMIN").antMatchers("/CustomerOrder/**").hasRole("CUSTOMER")
				.antMatchers("/adminuserregistration", "/customerregistration").permitAll()
				.antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/swagger-resources/configuration/ui", "/swagge‌​r-ui.html", "/swagger-resources/configuration/security").permitAll()
				.anyRequest().authenticated().and().formLogin();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
	}
//	
//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/v2/api-docs",
//                                   "/configuration/ui",
//                                   "/swagger-resources/**",
//                                   "/configuration/security",
//                                   "/swagger-ui.html",
//                                   "/webjars/**");
//    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("I am inside Password Encoder");

		return new BCryptPasswordEncoder();
	}

}
