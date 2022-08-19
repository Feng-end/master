package com.witsky.website.auth.domain2;

import com.witsky.website.base.*;
import com.witsky.website.common.WitSkyErrorCode;
import com.witsky.website.web.interceptor.SendMessageUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/26 11:04
 */
@Component
public class URIPermissionTokenFilter extends OncePerRequestFilter implements Starter {

    private List<String> needPermissionUrl ;

    //查看请求头中是否需要jwt
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isNeedPermissionUrl(request.getRequestURI())){
            String jwt = request.getHeader("jwt");
            if (StringUtils.isBlank(jwt)) {
                ApiResult<?> result = ApiResult.ofCode(WitSkyErrorCode.HEADER_LOST_JWT,"未找到 jwt" );
                    SendMessageUtil.sendJsonMessage(response,result );
                    return;
            }
        }
        filterChain.doFilter(request,response);
    }

    public boolean isNeedPermissionUrl(String requestURI) {
        for (String s : needPermissionUrl) {
            return requestURI.startsWith(s);
        }
        return false;
    }

    @Override
    public void onStart() throws Exception {
        List<String> list = new ArrayList<>();

        list.add("/admin");

        this.needPermissionUrl=Collections.unmodifiableList(list);
    }
}
