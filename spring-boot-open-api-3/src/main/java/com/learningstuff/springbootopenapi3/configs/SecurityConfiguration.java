package com.learningstuff.springbootopenapi3.configs;

import com.learningstuff.springbootopenapi3.security.APIKeyFilterRequest;
import com.learningstuff.springbootopenapi3.security.JwtFilterRequest;
import com.learningstuff.springbootopenapi3.security.MyAuthenticationEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ২৪/২/২২
 * Time: ১১:১৪ AM
 * Email: mdshamim723@gmail.com
 */

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();

        http.formLogin().and().httpBasic().disable();

        http.exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-*/**", "/v3/api-docs/**").permitAll()
                .anyRequest()
                .authenticated();

        http
                .addFilterBefore(new JwtFilterRequest(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new APIKeyFilterRequest(), UsernamePasswordAuthenticationFilter.class);

    }

}