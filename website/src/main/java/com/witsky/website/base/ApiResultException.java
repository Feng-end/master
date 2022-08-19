package com.witsky.website.base;

/**
 * @author YSJ
 * @date 2022/07/20 15:32
 */
public class ApiResultException extends RuntimeException{
    private final int code;

    private final String message;

    private final String description;

    public ApiResultException(int code, String description, String message) {
        this.code = code;
        this.description = description;
        this.message = message;
    }

    public ApiResultException(String message, int code, String description, String message1) {
        super(message);
        this.code = code;
        this.description = description;
        this.message = message1;
    }

    public ApiResultException(String message, Throwable cause, int code, String description, String message1) {
        super(message, cause);
        this.code = code;
        this.description = description;
        this.message = message1;
    }

    public ApiResultException(Throwable cause, int code, String description, String message) {
        super(cause);
        this.code = code;
        this.description = description;
        this.message = message;
    }

    public ApiResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code,
                              String description, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.description = description;
        this.message = message1;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
