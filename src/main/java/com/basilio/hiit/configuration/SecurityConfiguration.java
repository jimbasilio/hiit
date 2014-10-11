package com.basilio.hiit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.authorizeRequests().anyRequest().authenticated();
        // http.formLogin().failureUrl("/login?error").defaultSuccessUrl("/")
        // .loginPage("/login").permitAll().and().logout()
        // .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        // .logoutSuccessUrl("/login").permitAll();
        http.authorizeRequests().antMatchers("/manifest.appcache", "/about")
                .permitAll().anyRequest().authenticated().and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("")
                .roles("USER").and().withUser("ashley").password("password")
                .roles("USER");
    }
}