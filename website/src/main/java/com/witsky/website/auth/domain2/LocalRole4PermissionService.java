package com.witsky.website.auth.domain2;

import com.witsky.website.common.WebConstant;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author YSJ
 * @date 2022/07/25 15:12
 */
@Service
public class LocalRole4PermissionService {

    //现阶段默认写死
    public List<String> getPermission(LocalUserRoleType roleType){
        ArrayList<String> list = new ArrayList<>();
        if (roleType== LocalUserRoleType.ADMIN) {
            list.add(WebConstant.PATH_ADMIN);
            list.add(WebConstant.PATH_USER);
            return list;
        }
        return list;

    }

}
