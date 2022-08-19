package com.witsky.website.auth.domain2;

import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author YSJ
 * @date 2022/07/25 16:16
 */
@Service
public class AuthService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private JWTService jwtService;

    public String authentication(String username, String password){

        try {
            UsernamePasswordAuthenticationToken uptoken = new UsernamePasswordAuthenticationToken( username, password );

            Authentication authenticate = authenticationManager.authenticate(uptoken);

            SecurityContextHolder.getContext().setAuthentication(authenticate);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //JWT
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtService.generateToken(userDetails);
        return token;
    }

}
