package com.varNcremenet.authenticateservice.commons.security.config;

import com.varNcremenet.authenticateservice.commons.security.util.JwtTokenProvider;
import com.varNcremenet.authenticateservice.commons.security.service.JwtUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    JwtUserDetail jwtUserDetail;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetail).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/auth/token").permitAll()
                .antMatchers(HttpMethod.GET, "/auth/token").hasAnyRole("USER","ADMIN")

                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers(HttpMethod.PUT, "/user").hasAnyRole("USER","ADMIN")
                .antMatchers(HttpMethod.GET, "/user").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user/**").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider));
    }
}
