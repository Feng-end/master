package com.witsky.website.data.po.leaveWord;

import com.witsky.website.base.IdEnum;

/**
 * @author YSJ
 * @date 2022/07/22 10:11
 */
public enum LeaveWordClassifyType implements IdEnum<Integer> {

    DEFAULT(0,"未分类"),

    IMPORTANT(1,"重要"),

    ORDINARY(2,"普通"),

    INVALID(3,"无效")

    ;
    int id;

    String name;

     LeaveWordClassifyType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
}
