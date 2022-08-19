package com.witsky.website.auth.domain2;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/22 17:01
 */


@Service
public class LocalRoleService {
    //官网登陆后 默认拥有管理员权限
    public List<LocalUserRoleType> getUserRoleByName(String name){
        List<LocalUserRoleType> list = new ArrayList<>();
        list.add(LocalUserRoleType.ADMIN);
        return list;
    }

}
