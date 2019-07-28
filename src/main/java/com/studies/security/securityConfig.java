package com.studies.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter{
	 
	@Autowired
	private DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("USER","ADMIN");
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		*/
		
		auth.jdbcAuthentication().dataSource(datasource)
		.usersByUsernameQuery("select user_name as principal, password as credential, active from user where user_name=?")
		.authoritiesByUsernameQuery("select usr as principal, role as role from userrole where usr=?")
		.passwordEncoder(new Md5PasswordEncoder())
		.rolePrefix("ROLE_");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.formLogin().loginPage("/login");
		 http.authorizeRequests().antMatchers("/user/index").hasRole("user");
		 http.authorizeRequests().antMatchers("/admin/delete","/admin/update","/admin/save","/admin/insert").hasRole("admin");
		 http.exceptionHandling().accessDeniedPage("/nonautoriser");
	}
	
}
