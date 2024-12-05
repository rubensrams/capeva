package mx.com.sistema.cap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import mx.com.sistema.cap.service.impl.LoginServiceImpl;




@Configuration
public class SpringSecurityConfig {
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private SuccessHandler successHandler;

	
	@Bean 
     public static BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
     }

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(loginServiceImpl)
		.passwordEncoder(passwordEncoder());

	}
	

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.addFilterAfter(new LoginPageFilter(), UsernamePasswordAuthenticationFilter.class)
         		  .authorizeRequests().antMatchers("/", "/resources/**", "/javax.faces.resource/**", "/index.jsf").permitAll()
         		 .antMatchers("/pages/**").hasAnyRole("ADMIN")
                 .anyRequest()
                 .authenticated()
                 .and()
                 .formLogin().loginPage("/index.jsf")
                 .successHandler(successHandler)
                 .permitAll().failureUrl("/index.jsf?error=true")
                 .and()
                 .logout()
                 .logoutUrl("/logout")
                 .invalidateHttpSession(true)
                 .deleteCookies("JSESSIONID")
                 .permitAll();
         		http.csrf().disable();
  
         return http.build();
     }
	
}