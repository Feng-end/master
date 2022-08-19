package com.witsky.website.auth.domain2;

import org.apache.commons.lang3.AnnotationUtils;
import org.slf4j.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YSJ
 * @date 2022/07/22 16:06
 */
@Service
public class LocalUserService implements UserDetailsService {

    public static Logger L = LoggerFactory.getLogger(LocalUserService.class);

    @Resource
    private LocalUserManager localUserManager;

    @Resource
    private LocalRoleService roleService;

    @Resource
    private LocalRole4PermissionService role4PermissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LocalUser localUser = localUserManager.loadUserByUsername(username);
        List<LocalUserRoleType> roleTypeList = roleService.getUserRoleByName(username);
        List<String> permissions = new ArrayList<>();
        roleTypeList.forEach(c->{
            List<String> list = role4PermissionService.getPermission(c);
            permissions.addAll(list);
        });
        List<String> permissions4UserDetails = permissions.stream().map(c -> "ROLE_" + c).collect(Collectors.toList());
        permissions4UserDetails.addAll(roleTypeList.stream().map(LocalUserRoleType::toString).collect(Collectors.toList()));
        localUser.setAuthorities(
                AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", permissions4UserDetails))
        );
        L.info("SpringSecurity加载用户{},权限为{}",username,localUser.getAuthorities());
        return localUser;
    }
}
