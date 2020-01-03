package com.example.cursomcsozinho.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.cursomcsozinho.security.JWTAuthenticationFilter;
import com.example.cursomcsozinho.security.JWTAuthorizationFilter;
import com.example.cursomcsozinho.security.JWTUtil;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private Environment env;

	private static final String[] PUBLIC_MATCHERS = {
		"/h2-console/**",
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {
			"/produtos/**",
			"/categorias/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_POST = {
			"/clientes/**"
	}
	;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		http.cors().and().csrf().disable();
		http.authorizeRequests()
						.antMatchers(HttpMethod.POST,PUBLIC_MATCHERS_POST).permitAll()
						.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
						.antMatchers(PUBLIC_MATCHERS).permitAll()
						.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	  @Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
	    return source;
	  }
	  
	  @Bean
	  public  BCryptPasswordEncoder  bCryptPasswordEncoder() {
		  return new  BCryptPasswordEncoder();
	  }
	  
	  private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
			 
	        @Override
	        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
	                throws IOException, ServletException {
	            response.setStatus(401);
	            response.setContentType("application/json"); 
	            response.getWriter().append(json());
	        }
	        
	        private String json() {
	            long date = new Date().getTime();
	            return "{\"timestamp\": " + date + ", "
	                + "\"status\": 401, "
	                + "\"error\": \"Não autorizado\", "
	                + "\"message\": \"Email ou senha inválidos\", "
	                + "\"path\": \"/login\"}";
	        }
	    }
}
