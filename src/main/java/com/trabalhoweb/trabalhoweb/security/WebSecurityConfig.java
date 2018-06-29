package com.trabalhoweb.trabalhoweb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers(HttpMethod.GET, "/").permitAll()
		.antMatchers(HttpMethod.GET, "/produtos").permitAll()
		.antMatchers(HttpMethod.GET, "/cadastrarCliente").permitAll()
		.antMatchers(HttpMethod.POST, "/cadastrarCliente").permitAll()
		.antMatchers(HttpMethod.GET, "/addCarinho").permitAll()
		.antMatchers(HttpMethod.POST, "/addCarinho").permitAll()
		.antMatchers(HttpMethod.GET, "/detalhesProduto").permitAll()
		.antMatchers(HttpMethod.GET, "/{id}").permitAll()
		/*.antMatchers(HttpMethod.GET, "/cadastrarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/cadastrarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/listarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/deletarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/deletarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/atualizarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/atualizarProduto").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/finalizarCompra").hasRole("USER")*/
		.antMatchers(HttpMethod.GET, "/cadastrarProduto").permitAll()
		.antMatchers(HttpMethod.POST, "/cadastrarProduto").permitAll()
		.antMatchers(HttpMethod.GET, "/listarProduto").permitAll()
		.antMatchers(HttpMethod.GET, "/deletarProduto").permitAll()
		.antMatchers(HttpMethod.POST, "/deletarProduto").permitAll()
		.antMatchers(HttpMethod.GET, "/atualizarProduto").permitAll()
		.antMatchers(HttpMethod.POST, "/atualizarProduto").permitAll()
		.antMatchers(HttpMethod.GET, "/finalizarCompra").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService);
		auth.inMemoryAuthentication().withUser("ramon").password("123").roles("ADMIN");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/images/**", "/js/**");
	}
}
