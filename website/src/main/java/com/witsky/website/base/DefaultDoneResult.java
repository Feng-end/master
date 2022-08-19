package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:42
 */
public class DefaultDoneResult <M, C extends ResultCode>
        extends BaseDoneResult<M, DefaultDoneResult<M, C>, C>{

    DefaultDoneResult(C code, M returnValue) {
        super(code, returnValue);
    }

    DefaultDoneResult(C code, M returnValue, String message) {
        super(code, returnValue, message);
    }
}
