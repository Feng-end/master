package com.witsky.website.auth.domain2;

/**
 * @author YSJ
 * @date 2022/07/25 20:28
 */
public interface WebSiteAdminPermission {
    boolean isNeedPermissionUrl(String requestURI);
}
