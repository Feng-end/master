package com.witsky.website.base;

import java.util.Optional;

import static com.witsky.website.base.StringHelper.*;

/**
 * @author YSJ
 * @date 2022/07/20 15:33
 */
public class ApiException extends RuntimeException {
    private final ApiResultCode code;

    private final Object body;

    //    public static void throwByResult(DoneResult<?, ApiResultCode> done) {
    //        throw new ApiException(done);
    //    }
    //
    //    public static void throwByCode(ApiResultCode code) {
    //        throw new ApiException(code);
    //    }
    //
    //    public static void throwByCode(ApiResultCode code, String message, Object... messageParams) {
    //        throw new ApiException(code, message, messageParams);
    //    }
    //
    //    public static void throwByCause(ApiResultCode code, Throwable cause) {
    //        throw new ApiException(code, cause);
    //    }
    //
    //    public static void throwByCause(ApiResultCode code, Throwable cause, String message, Object... messageParams) {
    //        throw new ApiException(code, cause, message, messageParams);
    //    }
    //
    //    public static void throwByBody(ApiResultCode code, Object body) {
    //        throw new ApiException(code, body);
    //    }
    //
    //    public static void throwByBody(ApiResultCode code, Object body, String message, Object... messageParams) {
    //        throw new ApiException(code, body, message, messageParams);
    //    }

    public static ApiException of(DoneResult<?, ApiResultCode> done) {
        return new ApiException(done);
    }

    public static ApiException of(ApiResultCode code) {
        return new ApiException(code);
    }

    public static ApiException of(ApiResultCode code, String message, Object... messageParams) {
        return new ApiException(code, message, messageParams);
    }

    public static ApiException of(ApiResultCode code, Throwable cause) {
        return new ApiException(code, cause);
    }

    public static ApiException of(ApiResultCode code, Throwable cause, String message, Object... messageParams) {
        return new ApiException(code, cause, message, messageParams);
    }

    public static ApiException of(ApiResultCode code, Object body) {
        return new ApiException(code, body);
    }

    public static ApiException of(ApiResultCode code, Object body, String message, Object... messageParams) {
        return new ApiException(code, body, message, messageParams);
    }

    protected ApiException(DoneResult<?, ApiResultCode> done) {
        this(done.getCode(), done.getMessage());
    }

    protected ApiException(ApiResultCode code) {
        this(code, (Object)null, (Throwable)null, code.getMessage());
    }

    protected ApiException(ApiResultCode code, String message, Object... messageParams) {
        this(code, null, null, message, messageParams);
    }

    protected ApiException(ApiResultCode code, Throwable cause) {
        this(code, (Object)null, cause, code.getMessage());
    }

    protected ApiException(ApiResultCode code, Throwable cause, String message, Object... messageParams) {
        this(code, null, cause, message, messageParams);
    }

    protected ApiException(ApiResultCode code, Object body) {
        this(code, body, (Throwable)null, code.getMessage());
    }

    protected ApiException(ApiResultCode code, Object body, String message, Object... messageParams) {
        this(code, body, null, message, messageParams);
    }

    protected ApiException(ApiResultCode code, Object body, Throwable cause) {
        this(code, body, cause, code.getMessage());
    }

    protected ApiException(ApiResultCode code, Object body, Throwable cause, String message, Object... messageParams) {
        super(format(message, messageParams), cause);
        this.code = code;
        this.body = body;
    }

    public ApiResultCode getResultCode() {
        return code;
    }

    public Optional<Object> getBody() {
        return Optional.ofNullable(body);
    }

}
