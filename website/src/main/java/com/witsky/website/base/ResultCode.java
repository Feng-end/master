package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:34
 */
public interface ResultCode {
    int SUCCESS_CODE = 0;

    int getCode();

    default boolean isSuccess() {
        return getCode() == SUCCESS_CODE;
    }

    default boolean isFailure() {
        return !isSuccess();
    }

    String getMessage();

    default String getMessage(Object... messageParams) {
        if (messageParams == null || messageParams.length == 0) {
            return getMessage();
        }
        return StringHelper.format(getMessage(), messageParams);
    }

    static boolean isSuccessCode(int code) {
        return code == SUCCESS_CODE;
    }

}
