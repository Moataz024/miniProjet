package com.moataz.miniproject.security;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/order/api/all/**")
                .hasAnyAuthority("ADMIN","USER");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/order/api/**")
                .hasAnyAuthority("ADMIN","USER");
        http.authorizeRequests().antMatchers(HttpMethod.PUT,"/order/api/**")
                .hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/order/api/**")
                .hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/order/api/**")
                .hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


    }
}
