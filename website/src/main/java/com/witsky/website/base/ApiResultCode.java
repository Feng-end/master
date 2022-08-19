package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:33
 */
public interface ApiResultCode extends ResultCode, Identifiable<Integer>{

    HttpStatus getHttpStatus();

}
