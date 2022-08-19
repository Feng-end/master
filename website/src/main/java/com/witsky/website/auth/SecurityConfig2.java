package com.witsky.website.auth;

import com.witsky.website.auth.domain2.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author YSJ
 * @date 2022/07/20 14:03
 */
@Configurable
@EnableWebSecurity
public class SecurityConfig2  extends WebSecurityConfigurerAdapter {

    @Value("${witsky.auth-switch}")
    private String authSwitch;


    @Resource
    private LocalUserService localUserService;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private URIPermissionTokenFilter uriPermissionTokenFilter;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        if (!Boolean.parseBoolean(authSwitch)) {
            http.csrf().disable()
                    .authorizeRequests().anyRequest().permitAll();
        }

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/authentication","/").permitAll()
                .anyRequest().access("@localRBACService.hasPermission(request,authentication)")
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(uriPermissionTokenFilter,JwtAuthenticationTokenFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(localUserService);
    }

}
