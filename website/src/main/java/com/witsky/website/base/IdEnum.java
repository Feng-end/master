package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:52
 */
public interface IdEnum <ID> extends Identifiable<ID> {

    /**
     * 获取枚举名称
     */
    String getName();

}
