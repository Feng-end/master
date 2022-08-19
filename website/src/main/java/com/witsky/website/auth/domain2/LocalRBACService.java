package com.witsky.website.auth.domain2;

import com.witsky.website.base.*;
import com.witsky.website.common.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/25 16:10
 */
@Service
public class LocalRBACService implements WebSiteAdminURIPermission, Starter {


    private List<String> needPermissionUrl ;

    @Resource
    private JWTService jwtService;

    @Resource
    private UserDetailsService userDetailsService;
    /**
     * 判断某用户是否具有该request资源的访问权限
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication){

        Object principal = authentication.getPrincipal();
        String permission = getPermission(request.getRequestURI());
        if((principal instanceof UserDetails)){
            //获取当前登录用户的UserDetails
            UserDetails userDetails = ((UserDetails)principal);
            //将当前请求的访问资源路径，如:"/admin/aaa",包装成资源权限标识 Admin
            SimpleGrantedAuthority simpleGrantedAuthority
                    = new SimpleGrantedAuthority(permission);

            //判断用户已授权访问的资源中，是否包含“本次请求的资源”
            return userDetails.getAuthorities().contains(simpleGrantedAuthority);
        }
        return true;
    }

    @Override
    public String getPermission(String uri) {
        if (uri.contains(WebConstant.PATH_ADMIN)) {
            return LocalUserRoleType.ADMIN.toString();
        }
        return null;
    }

    @Override
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
