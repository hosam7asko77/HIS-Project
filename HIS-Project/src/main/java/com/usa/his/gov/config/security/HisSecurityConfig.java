package com.usa.his.gov.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.usa.his.gov.constant.HisConstant;

@EnableWebSecurity
public class HisSecurityConfig extends WebSecurityConfigurerAdapter {



	UserDetailsService userDetailsService;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public HisSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder ) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers(HisConstant.ERROR_PAGE)
				.permitAll().antMatchers(HisConstant.SET_PASSWORD_PROCESS_URL).permitAll()
				.antMatchers(HisConstant.SHOW_SET_PASSWORD_URL).permitAll().antMatchers("/RestApi/**").permitAll().antMatchers("/")
				.hasAnyRole(HisConstant.ADMIN, HisConstant.WORKER).antMatchers("/Admin/Manager/**").hasRole(HisConstant.ADMIN)
				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		super.configure(web);
	}

	
}
