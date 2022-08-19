package com.witsky.website.auth.domain2;

import com.witsky.website.base.IdEnum;

/**
 * @author YSJ
 * @date 2022/07/22 16:52
 */
public enum LocalUserRoleType implements IdEnum<Integer> {

    DEFAULT(1,"默认"),

    ADMIN(2,"管理员")

    ;

    int id;

    String name;

    LocalUserRoleType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
