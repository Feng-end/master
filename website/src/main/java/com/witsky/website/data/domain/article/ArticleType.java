package com.witsky.website.data.domain.article;

import com.witsky.website.base.IdEnum;

/**
 * @author YSJ
 * @date 2022/07/25 09:32
 */
public enum ArticleType implements IdEnum<Integer> {

    SEO(1,"SEO文章"),

    CUSTOMER_CASE(2,"客户案例"),

    SOLUTION(3,"解决方案")
    ;

    private int id;

    private String name;

    ArticleType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
