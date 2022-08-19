package com.witsky.website.auth.domain2;

/**
 * @author YSJ
 * @date 2022/07/25 20:30
 */
public interface WebSiteAdminURIPermission extends WebSiteAdminPermission{

    String getPermission(String uri);
}
