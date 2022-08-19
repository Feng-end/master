package com.witsky.website.auth.domain2;

import com.witsky.website.base.ApiException;
import com.witsky.website.common.WitSkyErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author YSJ
 * @date 2022/07/25 17:55
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    public static final String JWT_HEADER="jwt";


    @Resource
    private JWTService jwtService;

    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(JWT_HEADER);
        String username = null;
        if (StringUtils.isNotBlank(token)) {
            username = jwtService.getUsername(token);
        }

        if (!StringUtils.isBlank(username) && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);

    }
}
