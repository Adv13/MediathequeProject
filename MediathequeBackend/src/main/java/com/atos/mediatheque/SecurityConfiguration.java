package com.atos.mediatheque;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http
		 .csrf().disable()
		 .authorizeRequests() // ACLs
		 .antMatchers(HttpMethod.GET,"/items/**").permitAll()
		 .antMatchers("/emprunt/**").authenticated()
		 .anyRequest().authenticated()
		 .and()
		 .formLogin()// Page de login
		 .permitAll()
		 .and()
		 .logout() // forme du logout
		 .logoutUrl("/logout")
		.logoutSuccessUrl("/api/users")
		 .invalidateHttpSession(true);
		 
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(web);
		web.ignoring()
		.antMatchers("/**/*.js","/**/*.css","/**/*.png","/**/*.ico");//ignorer les javascrpt, les css et les images

	}
}
