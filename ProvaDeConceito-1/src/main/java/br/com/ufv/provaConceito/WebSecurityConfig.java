package br.com.ufv.provaConceito;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userService;
	
// 	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;


//	@Value("${spring.queries.users-query}")
//	private String usersQuery;
//
//	@Value("${spring.queries.roles-query}")
//	private String rolesQuery;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth.
//			jdbcAuthentication()
//				.usersByUsernameQuery(usersQuery)
//				.authoritiesByUsernameQuery(rolesQuery)
//				.dataSource(dataSource)
//				.passwordEncoder(bCryptPasswordEncoder);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/registro","/cadastroRepublica","/assets/**","/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login").defaultSuccessUrl("/cadastroRepublica")
                .permitAll()
                .and()
            .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login").and().exceptionHandling()
			.accessDeniedPage("/access-denied")
            ;
    }
    
//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        @SuppressWarnings("deprecation")
//		UserDetails user =
//             User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

}